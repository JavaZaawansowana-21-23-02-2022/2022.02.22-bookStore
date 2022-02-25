package pl.comarch.szkolenia.book.store.database;

import pl.comarch.szkolenia.book.store.model.User;

import java.util.Optional;
import java.util.List;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    Optional<User> getUserById(int id);
    void addUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}
