package pl.comarch.szkolenia.book.store.database;

import pl.comarch.szkolenia.book.store.model.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> getBooks();
}
