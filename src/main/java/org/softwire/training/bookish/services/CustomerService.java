package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.Customers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private String hostname = "localhost";
    private String database = "test";
    private String user = "bookish";
    private String password = "bookish";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<Customers> getAllCustomers() {
        List<Customers> customers = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM customerlist")
                        .mapToBean(Customers.class)
                        .list()
        );

        return customers;
    }
}