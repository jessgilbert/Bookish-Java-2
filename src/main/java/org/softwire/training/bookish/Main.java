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
        System.out.println("JDBC method...");
        jdbcMethod();

        System.out.println("\nJDBI method...");
        jdbiMethod();
    }

    private static void jdbcMethod() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionString);
        try (Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM booklist";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int BookID = resultSet.getInt("BookId");
                String Author = resultSet.getString("Author");
                String BookName = resultSet.getString("BookName");

                    System.out.println("Book ID: " + BookID + " has author: '" + Author + "' and title: '" + BookName + "'");
            }
        }
    }

    private static void jdbiMethod() {
        Jdbi jdbi = Jdbi.create(connectionString);

        List<BookList> books = jdbi.withHandle(handle ->
            handle.createQuery("SELECT * FROM booklist")
                .mapToBean(BookList.class)
                .list()
        );

        for (BookList book: books) {
            System.out.println("Book ID: " + book.getBookID() + " has author: '" + book.getAuthor() + "' and title: '" + book.getBookName() + "'");
        }
    }
}
