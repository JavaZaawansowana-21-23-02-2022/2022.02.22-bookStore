package pl.comarch.szkolenia.book.store.database.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.book.store.database.IAddressDAO;
import pl.comarch.szkolenia.book.store.database.IUserDAO;
import pl.comarch.szkolenia.book.store.model.Address;
import pl.comarch.szkolenia.book.store.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements IUserDAO {

    @Autowired
    Connection connection;

    @Autowired
    IAddressDAO addressDAO;

    @Override
    public Optional<User> getUserByLogin(String login) {
        try {
            String sql = "SELECT * FROM tuser WHERE login = ?";

            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int addressId = rs.getInt("address_id");

                return Optional.of(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        this.addressDAO.getAddressById(addressId).orElse(null)));
            }
        } catch (SQLException throwables) {
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> getUserById(int id) {
        try {
            String sql = "SELECT * FROM tuser WHERE id = ?";

            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                int addressId = rs.getInt("address_id");

                return Optional.of(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        this.addressDAO.getAddressById(addressId).orElse(null)));
            }
        } catch (SQLException throwables) {
        }

        return Optional.empty();
    }

    @Override
    public void addUser(User user) {
        try {
            this.addressDAO.addAddress(user.getAddress());

            String sql = "INSERT INTO tuser (login, password, address_id) VALUES (?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getAddress().getId());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (SQLException throwables) {

        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM tuser WHERE id = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tuser";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int addressId = rs.getInt("address_id");

                result.add(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        this.addressDAO.getAddressById(addressId).orElse(null)));
            }
        } catch (SQLException throwables) {
        }

        return result;
    }
}
