package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private String hostname = "localhost";
    private String database = "test";
    private String user = "bookish";
    private String password = "bookish";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<Book> getAllBooks() {
        List<Book> books = jdbi.withHandle(handle ->
            handle.createQuery("SELECT * FROM booklist")
                .mapToBean(Book.class)
                .list()
        );

        return books;
    }

    public void addBook(Book book) {
        jdbi.withHandle(handle ->
            handle.createUpdate("INSERT INTO test.booklist (BookName, Author) VALUES (:bookName,:author)")
                .bindBean(book)
                .execute()
        );
    }

    public void deleteBook(int bookId) {
        jdbi.withHandle(handle ->
            handle.createUpdate("DELETE FROM test.booklist WHERE BookId = :bookId")
                .bind("bookId", bookId)
                .execute()
        );
    }

    public List<Book> searchForBook(String searched) {
            List<Book> searchedBooks = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM test.booklist WHERE BookName=:search")
                        .bind("search", searched)
                        .mapToBean(Book.class)
                        .list()
        );

        return searchedBooks;
    }
}
