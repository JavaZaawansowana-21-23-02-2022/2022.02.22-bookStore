package pl.comarch.szkolenia.book.store.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.model.dto.UserDTO;
import pl.comarch.szkolenia.book.store.model.dto.UserListResponseDTO;
import pl.comarch.szkolenia.book.store.services.IUserService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        Optional<User> userBox = this.userService.getUserById(id);

        if(userBox.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(userBox.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public UserListResponseDTO getUsers(@RequestParam(required = false) String login) {
        UserListResponseDTO response = new UserListResponseDTO();
        if(login == null) {
            response.setUsers(this.userService.getAllUsers());
        } else {
            Optional<User> userBox = this.userService.getUserByLogin(login);
            userBox.ifPresent(user -> response.getUsers().add(user));
        }

        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        this.userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }
}
