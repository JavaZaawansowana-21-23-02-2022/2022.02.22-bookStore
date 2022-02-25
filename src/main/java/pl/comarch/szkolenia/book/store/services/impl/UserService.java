package pl.comarch.szkolenia.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.comarch.szkolenia.book.store.database.IUserDAO;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.services.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public Optional<User> getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return this.userDAO.getUserByLogin(login);
    }

    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        this.userDAO.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }
}
