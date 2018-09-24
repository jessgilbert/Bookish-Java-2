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

    public void addCustomer(Customers customers) {
        jdbi.withHandle(handle ->
                handle.createUpdate("INSERT INTO test.customerlist (Email, Password, FirstName, Surname) VALUES (:email, :password, :firstName, :surname)")
                        .bindBean(customers)
                        .execute()
        );
    }

    public void deleteCustomer(int personId) {
        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM test.customerlist WHERE PersonID = :personId")
                        .bind("personId", personId)
                        .execute()
        );

    }


    public List<Customers> searchForCustomers(String CustomerSearched) {
        List<Customers> searchedCustomers = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM test.customerlist WHERE FirstName =:search OR surname =:search OR Email =:search OR PersonID=:search")
                        .bind("search", CustomerSearched)
                        .mapToBean(Customers.class)
                        .list()
        );
        return searchedCustomers;
    }
}
