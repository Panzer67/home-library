/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Author;
import java.util.List;


public interface AuthorDao {

    public List<Author> list();

    public Author get(int id);

    public Author getAuthorByName(String firstname, String lastname);

    public void saveOrUpdate(Author author);

    public void delete(int id);
}
