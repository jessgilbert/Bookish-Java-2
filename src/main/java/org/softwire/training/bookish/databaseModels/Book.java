package org.softwire.training.bookish.databaseModels;

public class Book {

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
