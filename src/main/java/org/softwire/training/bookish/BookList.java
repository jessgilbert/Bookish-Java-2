package org.softwire.training.bookish;

public class BookList {

    private int BookID;
    private String BookName;
    private String Author;

    public int getBookID() {
        return BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setBookID(int bookID) {
        this.BookID = bookID;
    }

    public void setBookName(String bookName) {
        this.BookName = bookName;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }
}
