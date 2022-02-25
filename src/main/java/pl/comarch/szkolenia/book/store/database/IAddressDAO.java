package pl.comarch.szkolenia.book.store.database;

import pl.comarch.szkolenia.book.store.model.Address;

import java.util.Optional;

public interface IAddressDAO {
    Optional<Address> getAddressById(int id);
    void addAddress(Address address);
}
