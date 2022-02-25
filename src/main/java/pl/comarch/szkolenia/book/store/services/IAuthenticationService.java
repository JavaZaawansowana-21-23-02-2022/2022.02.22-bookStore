package pl.comarch.szkolenia.book.store.services;

public interface IAuthenticationService {
    void authenticate(String login, String password);
    void logout();
}
