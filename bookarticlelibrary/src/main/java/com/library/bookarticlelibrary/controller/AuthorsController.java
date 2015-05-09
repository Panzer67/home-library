/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.controller;

import com.library.bookarticlelibrary.dao.AuthorDao;
import com.library.bookarticlelibrary.model.Author;
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
public class AuthorsController {

    @Autowired
    private AuthorDao authorDao;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public ModelAndView displayAuthors() {
        ModelAndView model = new ModelAndView("authors");
        List<Author> authorList = authorDao.list();
        model.addObject("title", "authors");
        model.addObject("authorList", authorList);

        return model;
    }

    @RequestMapping(value = "/authors/author/{authorId}", method = RequestMethod.GET)
    public ModelAndView displayAuthor(@PathVariable("authorId") int authorId) {
        Author author = authorDao.get(authorId);
        ModelAndView model = new ModelAndView("author");
        model.addObject("title", "authors");
        model.addObject("author", author);

        return model;
    }

    @RequestMapping(value = "/authors/author/addauthor", method = RequestMethod.GET)
    public ModelAndView displayAddAuthor() {
        ModelAndView model = new ModelAndView("addauthor");
        model.addObject("title", "authors");
        model.addObject("author", new Author());

        return model;
    }

    @RequestMapping(value = {"authors/author/saveauthor", "authors/author/editauthor/saveauthor"}, method = RequestMethod.POST)
    public ModelAndView saveAuthor(@Valid Author author, BindingResult authorResult) {
        if (authorResult.hasErrors()) {
            return new ModelAndView("addauthor");
        }
        authorDao.saveOrUpdate(author);

        return new ModelAndView("redirect:/library/authors");
    }

    @RequestMapping(value = "authors/author/editauthor/{authorId}", method = RequestMethod.GET)
    public ModelAndView editAuthor(@PathVariable("authorId") int authorId) {
        Author author = authorDao.get(authorId);
        ModelAndView model = new ModelAndView("addauthor");
        model.addObject("title", "authors");
        model.addObject("author", author);

        return model;
    }
}
