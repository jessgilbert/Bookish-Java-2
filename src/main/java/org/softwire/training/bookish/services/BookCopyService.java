package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.softwire.training.bookish.databaseModels.Customers;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookCopyService {
    private String hostname = "localhost";
    private String database = "test";
    private String user = "bookish";
    private String password = "bookish";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<BookCopy> getAllBooks(int bookId) {
        List<BookCopy> bookCopies = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookcopies WHERE BookId = :bookId")
                        .bind("bookId",bookId)
                        .mapToBean(BookCopy.class)
                        .list()
        );

        return bookCopies;
    }

    public void addBookCopy(BookCopy book) {
        jdbi.withHandle(handle ->
                handle.createUpdate("INSERT INTO test.bookcopies (BookId) VALUES (:bookId)")
                        .bind("bookId",book.BookID)
                        .execute()
        );
    }

    public void deleteBookCopy(int CopyID) {
        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM test.bookcopies WHERE CopyId = :copyId")
                        .bind("copyId", CopyID)
                        .execute()
        );
    }

    public List<BookCopy> searchForBookCopy(String BookSearched) {
        List<BookCopy> searchedBooks = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM test.bookcopies WHERE BookID=:search OR CopyID=:search")
                        .bind("search", BookSearched)
                        .mapToBean(BookCopy.class)
                        .list()
        );

        return searchedBooks;
    }

    public void addCheckOut(int personId, int copyId) {
        jdbi.withHandle(handle ->
                handle.createUpdate("UPDATE `test`.`bookcopies` SET `CheckedOutBy` = :personId WHERE `CopyID` = :copyId")
                        .bind("personId", personId)
                        .bind("copyId", copyId)
                        .execute()
        );
    }

}

