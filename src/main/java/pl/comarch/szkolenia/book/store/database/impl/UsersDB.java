package pl.comarch.szkolenia.book.store.database.impl;

import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.book.store.database.IUserDAO;
import pl.comarch.szkolenia.book.store.model.Address;
import pl.comarch.szkolenia.book.store.model.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class UsersDB implements IUserDAO {
    List<User> users = new ArrayList<>();

    public UsersDB() {
        this.users.add(new User(
                1,
                "janusz",
                "janusz123",
                new Address(1, "Jakas", "5", "32-234", "Kraków")
        ));

        this.users.add(new User(
                2,
                "admin",
                "admin",
                new Address(2, "Inna", "10", "32-234", "Kraków")
        ));
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return this.users.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return this.users.stream().filter(user -> user.getId() == id).findAny();
    }

    @Override
    public void addUser(User user) {
        /*Random random = new Random();
        user.setId(random.nextInt(10000000));
        this.users.add(user);
        return user;*/
        throw new NotImplementedException();
    }

    @Override
    public void deleteUser(int id) {
        this.users.removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
}
