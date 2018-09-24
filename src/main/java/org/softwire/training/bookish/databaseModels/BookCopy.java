package org.softwire.training.bookish.databaseModels;

import java.time.LocalDate;

public class BookCopy {
    private int CopyID;
    private int BookID;
    private String CheckedOutBy;
    private LocalDate ReturnDate;

    public int getCopyID() {
        return CopyID;
    }

    public int getBookID() {
        return BookID;
    }

    public String getCheckedOutBy() {
        return CheckedOutBy;
    }

    public LocalDate getReturnDate() {
        return ReturnDate;
    }

    public void setCopyID(int copyID) {
        this.CopyID = copyID;
    }

    public void setBookID(int bookID) {
        this.BookID = bookID;
    }

    public void setCheckedOutBy(String checkedOutBy) {
        this.CheckedOutBy = checkedOutBy;
    }

    public void setReturnDate(LocalDate returnDate) {
        ReturnDate = returnDate;
    }
}
