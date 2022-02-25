package pl.comarch.szkolenia.book.store.services;

import pl.comarch.szkolenia.book.store.model.User;

import java.util.Optional;
import java.util.List;

public interface IUserService {
    Optional<User> getUserById(int id);
    Optional<User> getUserByLogin(String login);
    void addUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}
