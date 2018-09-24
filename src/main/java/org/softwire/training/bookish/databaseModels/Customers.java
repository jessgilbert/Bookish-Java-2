package org.softwire.training.bookish.databaseModels;

public class Customers {
    private int PersonID;
    private String Email;
    private String Password;
    private String FirstName;
    private String Surname;

    public int getPersonID() {
        return PersonID;
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

    public void setPersonID(int personID) {
        this.PersonID = personID;
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
