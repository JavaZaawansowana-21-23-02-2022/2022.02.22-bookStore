package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.comarch.szkolenia.book.store.model.Address;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.services.IUserService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddressById(@PathVariable int id) {
        Optional<Address> addressBox =
                this.userService.getAllUsers().stream()
                        .map(User::getAddress)
                        .filter(address -> address.getId() == id)
                        .findAny();

        if(addressBox.isPresent()) {
            return ResponseEntity.status(200).body(addressBox.get());
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
