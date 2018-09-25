package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.softwire.training.bookish.databaseModels.Customers;
import org.softwire.training.bookish.services.BookCopyService;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.services.CustomerService;
import org.softwire.training.bookish.viewModels.BookCopyPageModel;
import org.softwire.training.bookish.viewModels.BooksPageModel;
import org.softwire.training.bookish.viewModels.CustomersPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

//sends you to the other pages//
@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    //when there is a single slash calls html file "index"//
    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    //displays table of all books//
    @RequestMapping("/allBooks")
    ModelAndView books() {

        //creates table of all given books//
        List<Book> allBooks = bookService.getAllBooks();

        //creates new page instance to display the books and then sends the page the list//
        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.books = allBooks;

        //creates page using "books" html and class bookPageModel, using model to call the class//
        return new ModelAndView("books", "model", booksPageModel);
    }

    //adds book to allBooks//
    @RequestMapping("/allBooks/add")
    //gets the push from book html and makes it into book object//
    RedirectView addBook(@ModelAttribute Book book) {

        //adds the book to the list in bookServices//
        bookService.addBook(book);

        //reloads the /allBooks page//
        return new RedirectView("/allBooks");
    }

    //deletes a book//
    @RequestMapping("/allBooks/delete")
    //gets the book id value as int from book html//
    RedirectView deleteBook(@RequestParam int bookId) {

        //calls deleteBook in bookService class passing through bookId//
        bookService.deleteBook(bookId);

        //reloads the /allBooks page//
        return new RedirectView("/allBooks");
    }

    //adds a customer//
    @RequestMapping("/Customers/add")
    //gets the push from customer html and makes it into customer object//
    RedirectView addCustomer(@ModelAttribute Customers customers) {

        //adds it to list in customer service//
        customerService.addCustomer(customers);

        //reloads /Customers//
        return new RedirectView("/Customers");
    }

    //deletes a customer//
    @RequestMapping("/Customers/delete")
    //gets personId as int from customers class//
    RedirectView deleteCustomer(@RequestParam int personId) {

        //calls delete customer in customerService//
        customerService.deleteCustomer(personId);

        //reloads the page//
        return new RedirectView("/Customers");
    }

    //searches for books//
    @RequestMapping("/allBooks/search")
    //gets your search input from books html as string//
    ModelAndView searchForBook(@RequestParam String BookSearched) {

        //makes books into list equal what you've searched//
        List<Book> allBooks = bookService.searchForBook(BookSearched);

        //creates new instance of the page//
        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.books = allBooks;

        //re-displays the page with only the books you searched showing//
        return new ModelAndView("books", "model", booksPageModel);

    }

    //searches for customers//
    @RequestMapping("/Customers/search")
    ModelAndView searchForCustomers(@RequestParam String CustomerSearched) {

        //makes customers into list equal to what you've searched//
        List<Customers> allCustomers = customerService.searchForCustomers(CustomerSearched);

        //creates new instance of the page//
        CustomersPageModel customersPageModel = new CustomersPageModel();
        customersPageModel.customers = allCustomers;

        //re-displays the page with only the customers you searched showing//
        return new ModelAndView("customers", "model", customersPageModel);

    }

    @Autowired
    private CustomerService customerService;

    //displays table of all customers//
    @RequestMapping("/Customers")
    ModelAndView customers() {
        //creates list customers with all the customers//
        List<Customers> allCustomers = customerService.getAllCustomers();

        //creates new instance of the page//
        CustomersPageModel customersPageModel = new CustomersPageModel();
        customersPageModel.customers = allCustomers;

        //creates the page with html customers and with object customersPageModel//
        return new ModelAndView("customers", "model", customersPageModel);
    }

    @Autowired
    private BookCopyService bookCopyService;

    @RequestMapping("/allBooks/bookcopy")
    ModelAndView bookCopies(@RequestParam int bookId) {

        //creates table of all given books copies//
        List<BookCopy> allBookCopies = bookCopyService.getAllBooks(bookId);

        //creates new page instance to display the book copies and then sends the page the list//
        BookCopyPageModel bookCopyPageModel = new BookCopyPageModel();
        bookCopyPageModel.bookCopies = allBookCopies;

        //creates page using "books" html and class bookPageModel, using model to call the class//
        return new ModelAndView("bookCopies", "model", bookCopyPageModel);
    }


    @RequestMapping("/allBooks/bookcopy/add")
    RedirectView addBookCopies(@ModelAttribute BookCopy book) {

        bookCopyService.addBookCopy(book);

        return new RedirectView("/allBooks/bookcopy?bookId=" + book.BookID);
    }

    @RequestMapping("/allBooks/bookcopy/delete")
        //gets the book id value as int from book html//
    RedirectView deleteBookCopy(@RequestParam String copyId) {

        System.out.println(copyId);

        //calls deleteBook in bookService class passing through bookId//
       // bookCopyService.deleteBookCopy(copyId);

        //reloads the /allBooks page//
        return new RedirectView("/allBooks/bookcopy");
    }

    @RequestMapping("/allBooks/bookcopy/addCheckout")
    RedirectView addCheckOut(@ModelAttribute BookCopy bookCopy) {

        bookCopyService.addCheckOut(bookCopy);

        return new RedirectView("/allBooks/bookcopy");
    }

//    //displays table of all books//
//    @RequestMapping("/checkOut")
//    ModelAndView checkOut() {
//
//        //creates table of all given books//
//        List<Book> allBooks = bookService.getAllBooks();
//
//        //creates new page instance to display the books and then sends the page the list//
//        BooksPageModel booksPageModel = new BooksPageModel();
//        booksPageModel.books = allBooks;
//
//        //creates page using "books" html and class bookPageModel, using model to call the class//return new ModelAndView("checkOut", "model", CheckOutPageModel);

}
