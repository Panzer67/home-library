/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Article;
import java.util.List;

public interface ArticleDao {
    
    public List<Article> list();
    
    public Article get(int id);
     
    public void saveOrUpdate(Article article);
     
    public void delete(int id);
}
