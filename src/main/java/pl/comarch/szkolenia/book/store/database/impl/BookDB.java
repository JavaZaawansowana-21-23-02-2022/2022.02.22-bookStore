package pl.comarch.szkolenia.book.store.database.impl;

import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.book.store.database.IBookDAO;
import pl.comarch.szkolenia.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDB implements IBookDAO {
    List<Book> books = new ArrayList<>();

    public BookDB() {
        this.books.add(new Book(
                1,
                "PowerShell. Leksykon kieszonkowy. Przenośna pomoc dla tworzących skrypty w PowerShell. Wydanie III",
                "Lee Holmes",
                39.90,
                "978-83-283-8383-8"
        ));

        this.books.add(new Book(
                2,
                "Projektowanie baz danych dla każdego. Przewodnik krok po kroku. Wydanie IV",
                "Michael J. Hernandez",
                59.40,
                "978-83-283-8251-0"
        ));

        this.books.add(new Book(
                3,
                "Kubernetes i Docker w środowisku produkcyjnym przedsiębiorstwa. Konteneryzacja i skalowanie aplikacji oraz jej integracja z systemami korporacyjnymi",
                "Scott Surovich, Marc Boorshtein",
                59.40,
                "978-83-283-8629-7"
        ));
    }

    public List<Book> getBooks() {
        return this.books;
    }
}
