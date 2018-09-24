package org.softwire.training.bookish.databaseModels;

//This is object book that has info for everything we need to know about book//
public class Book {

    //declaring variables//
    public int BookID;
    public String BookName;
    public String Author;

    public int getBookID() {
        return BookID;
    }
    public String getBookName() {
        return BookName;
    }
    public String getAuthor() {
        return Author;
    }

    public void setBookID(int bookId) {
        this.BookID = bookId;
    }

    public void setBookName(String bookName) {
        this.BookName = bookName;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }
}
