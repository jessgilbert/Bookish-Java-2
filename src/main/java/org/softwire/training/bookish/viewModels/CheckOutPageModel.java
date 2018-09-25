package org.softwire.training.bookish.viewModels;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.softwire.training.bookish.databaseModels.Customers;

import java.util.List;

public class CheckOutPageModel {
    public List<Book> books;
    public List<BookCopy> bookCopies;
    public List<Customers> customers;

}
