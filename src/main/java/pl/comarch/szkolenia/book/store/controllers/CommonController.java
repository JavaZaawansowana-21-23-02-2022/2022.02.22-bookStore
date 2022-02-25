package pl.comarch.szkolenia.book.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.comarch.szkolenia.book.store.database.IBookDAO;
import pl.comarch.szkolenia.book.store.model.Book;
import pl.comarch.szkolenia.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    IBookDAO bookDB;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        if(this.sessionObject.isLogged()) {
            List<Book> books = this.bookDB.getBooks();
            model.addAttribute("books", books);
        } else {
            model.addAttribute("books", new ArrayList<>());
        }
        model.addAttribute("logged", this.sessionObject.isLogged());

        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "contact";
    }


    @RequestMapping(value = "/cos", method = RequestMethod.GET)
    public String cos1(@RequestParam int p1, @RequestParam int p2) {
        System.out.println(p1);
        System.out.println(p2);
        return "redirect:/main";
    }

    @RequestMapping(value = "/cos2/{parametr1}/{parametr2}", method = RequestMethod.GET)
    public String cos2(@PathVariable String parametr1, @PathVariable String parametr2) {
        System.out.println(parametr1);
        System.out.println(parametr2);

        return "redirect:/main";
    }
}
