/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Book;
import java.util.List;

/**
 *
 * @author tni20865
 */
public interface BookDao {
    
    public List<Book> list();
    
    public Book get(int id);
     
    public void saveOrUpdate(Book book);
     
    public void delete(int id);
}
