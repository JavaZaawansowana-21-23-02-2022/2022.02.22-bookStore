package pl.comarch.szkolenia.book.store.model.dto;

import pl.comarch.szkolenia.book.store.model.User;

public class UserDTO {
    private int id;
    private String login;
    private String password;
    private String address;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.address = "localhost:8080/address/" + user.getAddress().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
