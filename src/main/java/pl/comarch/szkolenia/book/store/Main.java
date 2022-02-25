package pl.comarch.szkolenia.book.store;

import pl.comarch.szkolenia.book.store.model.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore10", "root", "");

        String SQL = "INSERT INTO taddress (street, no, code, city) VALUES ('Ogrodowa', '5', '23-234', 'Poznan')";

        Statement statement = connection.createStatement();
        statement.execute(SQL);


        String SQLSelect = "SELECT * FROM taddress";

        Statement statement1 = connection.createStatement();
        ResultSet rs = statement1.executeQuery(SQLSelect);
        List<Address> addressList = new ArrayList<>();
        while (rs.next()) {
            Address address = new Address(
                    rs.getInt("id"),
                    rs.getString("street"),
                    rs.getString("no"),
                    rs.getString("code"),
                    rs.getString("city"));

            addressList.add(address);
        }

        System.out.println(addressList);

        connection.close();
    }
}
