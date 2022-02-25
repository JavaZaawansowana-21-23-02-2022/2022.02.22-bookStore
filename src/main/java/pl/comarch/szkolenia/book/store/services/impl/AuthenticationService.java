package pl.comarch.szkolenia.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.comarch.szkolenia.book.store.database.IUserDAO;
import pl.comarch.szkolenia.book.store.model.User;
import pl.comarch.szkolenia.book.store.services.IAuthenticationService;
import pl.comarch.szkolenia.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IUserDAO userDB;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userDB.getUserByLogin(login);

        if(userBox.isPresent() && userBox.get().getPassword().equals(password)) {
            this.sessionObject.setLogged(true);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLogged(false);
    }
}
