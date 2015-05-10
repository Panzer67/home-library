/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.controller;

import com.library.bookarticlelibrary.dao.JournalDao;
import com.library.bookarticlelibrary.model.Journal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JournalsController {
    
    @Autowired
    private JournalDao journalDao;
    
    @RequestMapping(value = "/journals", method = RequestMethod.GET)
    public ModelAndView displayJournals() {
        ModelAndView model = new ModelAndView("journals");
        List<Journal> journalList = journalDao.list();
        model.addObject("title", "journals");
        model.addObject("journalList", journalList);
        
        return model;
    }
    
    @RequestMapping(value = "/journals/journal/{journalId}", method = RequestMethod.GET)
    public ModelAndView displayJournal(@PathVariable("journalId") int journalId) {
        ModelAndView model = new ModelAndView("journal");
        Journal journal = journalDao.get(journalId);
        model.addObject("title", "journals");
        model.addObject("journal", journal);
        
        return model;
    }
}
