package org.softwire.training.bookish.databaseModels;

import java.time.LocalDate;

public class BookCopy {
    public int CopyID;
    public int BookID;
    public String CheckedOutBy;
    public LocalDate ReturnDate;

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
