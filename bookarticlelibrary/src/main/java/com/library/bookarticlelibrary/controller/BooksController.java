/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.controller;

import com.library.bookarticlelibrary.dao.AuthorDao;
import com.library.bookarticlelibrary.dao.BookDao;
import com.library.bookarticlelibrary.model.Author;
import com.library.bookarticlelibrary.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BooksController {

    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private AuthorDao authorDao;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView displayBooks() {
        ModelAndView model = new ModelAndView("books");
        List<Book> bookList = bookDao.list();
        model.addObject("title", "books");
        model.addObject("bookList", bookList);

        return model;
    }

    @RequestMapping(value = "/books/book/{bookId}", method = RequestMethod.GET)
    public ModelAndView displayBook(@PathVariable("bookId") int bookId) {
        Book book = bookDao.get(bookId);
        ModelAndView model = new ModelAndView("book");
        model.addObject("book", book);

        return model;
    }

    @RequestMapping(value = "/books/addbook", method = RequestMethod.GET)
    public ModelAndView displayAddBook() {
        ModelAndView model = new ModelAndView("addbook");
        model.addObject("title", "Books");
        model.addObject("book", new Book());

        return model;
    }

    @RequestMapping(value = {"/books/savebook", "/books/book/editbook/savebook"}, method = RequestMethod.POST)
    public ModelAndView saveBook(@Valid Book book, BindingResult bookResult) {
        if (bookResult.hasErrors()) {
            return new ModelAndView("addbook");
        }
        List<Author> authors = book.getAuthors();
        List<Author> checkedAuthors = new ArrayList<>();
        for (Author author : authors) {
            author = authorDao.getAuthorByName(author.getFirstname(), author.getLastname());
            checkedAuthors.add(author);
        }
        book.setAuthors(checkedAuthors);
        bookDao.saveOrUpdate(book);

        return new ModelAndView("redirect:/library/books");

    }

    @RequestMapping(value = "/books/book/editbook/{bookId}", method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable("bookId") int bookId) {
        Book book = bookDao.get(bookId);
        ModelAndView model = new ModelAndView("editbook");
        model.addObject("book", book);

        return model;
    }

    @RequestMapping(value = "/books/book/deletebook/{bookId}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable("bookId") int bookId) {
        bookDao.delete(bookId);

        return new ModelAndView("redirect:/library/books");
    }
}
