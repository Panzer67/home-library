/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.controller;

import com.library.bookarticlelibrary.dao.ArticleDao;
import com.library.bookarticlelibrary.dao.AuthorDao;
import com.library.bookarticlelibrary.model.Article;
import com.library.bookarticlelibrary.model.Author;
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
public class ArticlesController {
    
    @Autowired
    private ArticleDao articleDao;
    
    @Autowired
    private AuthorDao authorDao;
    
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public ModelAndView displayArticles() {
        ModelAndView model = new ModelAndView("articles");
        List<Article> articleList = articleDao.list();
        model.addObject("title", "articles");
        model.addObject("articleList", articleList);                

        return model;
    }

    @RequestMapping(value = "/articles/article/{articleId}", method = RequestMethod.GET)
    public ModelAndView displayArticle(@PathVariable("articleId") int articleId) {
        Article article = articleDao.get(articleId);
        ModelAndView model = new ModelAndView("article");
        model.addObject("title", "articles");
        model.addObject("article", article);
        System.out.println("hallo");
        return model;
    }

    @RequestMapping(value = "/articles/addarticle", method = RequestMethod.GET)
    public ModelAndView displayAddArticle() {
        ModelAndView model = new ModelAndView("addarticle");
        model.addObject("article", new Article());
        model.addObject("author", new Author());

        return model;
    }

    @RequestMapping(value = {"/articles/article/editarticle/savearticle", "/articles/savearticle"}, method = RequestMethod.POST)
    public ModelAndView editArticle(@Valid Article article, BindingResult articleResult) {
        if (articleResult.hasErrors()) {
            return new ModelAndView("addarticle");
        }
        List<Author> authors = article.getAuthors();
        List<Author> checkedAuthors = new ArrayList<>();
        for (Author author : authors) {
            author = authorDao.getAuthorByName(author.getFirstname(), author.getLastname());
            checkedAuthors.add(author);
        }
        article.setAuthors(checkedAuthors);
        articleDao.saveOrUpdate(article);

        return new ModelAndView("redirect:/articles");
    }

    @RequestMapping(value = "/articles/article/editarticle/{articleId}", method = RequestMethod.GET)
    public ModelAndView editArticle(@PathVariable("articleId") int articleId) {
        Article article = articleDao.get(articleId);
        ModelAndView model = new ModelAndView("editarticle");
        model.addObject("title", "Edit Article");
        model.addObject("article", article);

        return model;
    }

    @RequestMapping(value = "/articles/article/deletearticle/{articleId}", method = RequestMethod.GET)
    public ModelAndView deleteArticle(@PathVariable("articleId") int articleId) {
        articleDao.delete(articleId);

        return new ModelAndView("redirect:/articles");
    }
}
