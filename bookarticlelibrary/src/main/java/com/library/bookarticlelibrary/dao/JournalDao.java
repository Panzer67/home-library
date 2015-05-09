/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Journal;
import java.util.List;

public interface JournalDao {

    public List<Journal> list();

    public Journal get(int id);

    public void saveOrUpdate(Journal journal);

    public void delete(int id);
}
