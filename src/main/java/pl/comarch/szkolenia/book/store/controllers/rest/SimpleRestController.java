package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.comarch.szkolenia.book.store.model.Address;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.model.User;

@RestController
public class SimpleRestController {

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public void service1() {

    }

    @RequestMapping(value = "/service2", method = RequestMethod.GET)
    public User service2() {
        User user = new User();
        user.setId(5);
        user.setLogin("jan");
        user.setPassword("jan2");

        return user;
    }

    @RequestMapping(value = "/service3", method = RequestMethod.POST)
    public User service3(@RequestBody User user) {
        user.setId(100);

        Address address = new Address(10, "Ogrodowa", "5", "12-123", "Krakow");

        user.setAddress(address);

        return user;
    }

    @RequestMapping(value = "/service4/{p1}/{p2}", method = RequestMethod.POST)
    public void service4(@RequestBody User user,
                         @PathVariable String p1,
                         @PathVariable String p2,
                         @RequestParam String parametr1,
                         @RequestHeader("header1") String h1,
                         @RequestHeader("header2") String h2) {
        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());

        System.out.println(p1);
        System.out.println(p2);

        System.out.println(parametr1);

        System.out.println(h1);
        System.out.println(h2);
    }

    @RequestMapping(value = "/service5", method = RequestMethod.GET)
    public ResponseEntity<Book> service5() {
        Book book = new Book(5, "Java", "Pan Janusz", 199.00, "1231-231-123-122");

        ResponseEntity<Book> response = ResponseEntity.status(405)
                .header("header1", "value1")
                .header("header2", "value2")
                .build();

        return response;
    }
}
