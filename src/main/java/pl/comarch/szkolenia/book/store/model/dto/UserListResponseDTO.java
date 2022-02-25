package pl.comarch.szkolenia.book.store.model.dto;

import pl.comarch.szkolenia.book.store.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListResponseDTO {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
