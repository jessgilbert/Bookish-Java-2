package org.softwire.training.bookish;

public class CustomerList {

    private int CustomerID;
    private String Email;
    private String Password;
    private String FirstName;
    private String Surname;

    public int getPersonID() {
        return CustomerID;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }
}
