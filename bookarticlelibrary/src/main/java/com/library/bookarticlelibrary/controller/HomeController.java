/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @RequestMapping(value= {"/", "/home" } , method = RequestMethod.GET)
    public ModelAndView displayHome() {
        ModelAndView model = new ModelAndView("home");
        model.addObject("name", "Tjeerdjan");
        model.addObject("title", "home");
        
        return model;
    }
    
    @RequestMapping(value= "/authors" , method = RequestMethod.GET)
    public ModelAndView displayAuthors() {
        ModelAndView model = new ModelAndView("authors");
        
        model.addObject("title", "authors");
        
        return model;
    }
    
    @RequestMapping(value= "/books" , method = RequestMethod.GET)
    public ModelAndView displayBooks() {
        ModelAndView model = new ModelAndView("books");
        
        model.addObject("title", "books");
        
        return model;
    }
    
    @RequestMapping(value= "/articles" , method = RequestMethod.GET)
    public ModelAndView displayArticles() {
        ModelAndView model = new ModelAndView("articles");
        
        model.addObject("title", "articles");
        
        return model;
    }
}
