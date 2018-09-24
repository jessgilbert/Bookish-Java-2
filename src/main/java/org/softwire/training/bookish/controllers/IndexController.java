package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.Customers;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.services.CustomerService;
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

/**
 * Controller for the index page
 */
@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/allBooks")
    ModelAndView books() {

        List<Book> allBooks = bookService.getAllBooks();

        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.books = allBooks;

        return new ModelAndView("books", "model", booksPageModel);
    }

    @RequestMapping("/allBooks/add")
    RedirectView addBook(@ModelAttribute Book book) {

        bookService.addBook(book);

        return new RedirectView("/allBooks");
    }

    @RequestMapping("/allBooks/delete")
    RedirectView deleteBook(@RequestParam int bookId) {

        bookService.deleteBook(bookId);

        return new RedirectView("/allBooks");
    }

    @RequestMapping("/Customers/add")
    RedirectView addCustomer(@ModelAttribute Customers customers) {

        customerService.addCustomer(customers);

        return new RedirectView("/Customers");
    }

    @RequestMapping("/Customers/delete")
    RedirectView deleteCustomer(@RequestParam int personId) {

        customerService.deleteCustomer(personId);

        return new RedirectView("/Customers");
    }


    @RequestMapping("/allBooks/search")
    ModelAndView searchForBook(@RequestParam String BookSearched) {

        List<Book> allBooks = bookService.searchForBook(BookSearched);

        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.books = allBooks;

        return new ModelAndView("books", "model", booksPageModel);

    }

    @RequestMapping("/Customers/search")
    ModelAndView searchForCustomers(@RequestParam String CustomerSearched) {

        List<Customers> allCustomers = customerService.searchForCustomers(CustomerSearched);

        CustomersPageModel customersPageModel = new CustomersPageModel();
        customersPageModel.customers = allCustomers;

        return new ModelAndView("customers", "model", customersPageModel);

    }

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/Customers")
    ModelAndView customers() {
        List<Customers> allCustomers = customerService.getAllCustomers();

        CustomersPageModel customersPageModel = new CustomersPageModel();
        customersPageModel.customers = allCustomers;

        return new ModelAndView("customers", "model", customersPageModel);
    }

}
