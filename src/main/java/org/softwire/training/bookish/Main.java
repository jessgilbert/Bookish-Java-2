package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;

import java.sql.*;
import java.util.List;

public class Main {
    private static String hostname = "localhost";
    private static String database = "test";
    private static String user = "bookish";
    private static String password = "bookish";
    private static String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    public static void main(String[] args) throws SQLException {

        System.out.println("\nJDBI method...");
        jdbiMethod();
    }


    private static void jdbiMethod() {
        Jdbi jdbi = Jdbi.create(connectionString);

        List<Book> books = jdbi.withHandle(handle ->
            handle.createQuery("SELECT * FROM books")
                .mapToBean(Book.class)
                .list()
        );

        for (Book book: books) {
            System.out.println("Book ID: " + book.getBookID() + " has author: '" + book.getAuthor() + "' and title: '" + book.getBookName() + "'");
        }
    }
}
