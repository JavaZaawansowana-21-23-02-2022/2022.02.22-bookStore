package pl.comarch.szkolenia.book.store.model;

import javax.persistence.*;

@Entity(name = "taddress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String no;
    private String code;
    private String city;

    public Address(int id, String street, String no, String code, String city) {
        this.id = id;
        this.street = street;
        this.no = no;
        this.code = code;
        this.city = city;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", no='" + no + '\'' +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
