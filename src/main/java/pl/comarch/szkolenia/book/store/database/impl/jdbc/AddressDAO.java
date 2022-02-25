package pl.comarch.szkolenia.book.store.database.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.book.store.database.IAddressDAO;
import pl.comarch.szkolenia.book.store.model.Address;

import java.sql.*;
import java.util.Optional;

public class AddressDAO implements IAddressDAO {

    @Autowired
    Connection connection;

    @Override
    public Optional<Address> getAddressById(int id) {
        try {
            String sql = "SELECT * FROM taddress WHERE id = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                return Optional.of(new Address(rs.getInt("id"),
                rs.getString("street"),
                rs.getString("no"),
                rs.getString("code"),
                rs.getString("city")));
            }
        } catch (SQLException throwables) {
        }

        return Optional.empty();
    }

    @Override
    public void addAddress(Address address) {
        try {
            String sql = "INSERT INTO taddress (street, no, code, city) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getNo());
            statement.setString(3, address.getCode());
            statement.setString(4, address.getCity());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            address.setId(rs.getInt(1));
        } catch (SQLException throwables) {
        }
    }
}
