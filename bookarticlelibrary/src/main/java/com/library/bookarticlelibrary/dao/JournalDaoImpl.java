/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Journal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JournalDaoImpl implements JournalDao {

    @Autowired
    private SessionFactory sessionFactory;

    public JournalDaoImpl() {

    }

    public JournalDaoImpl(SessionFactory sessionFactory) {

    }

    @Override
    @Transactional
    public List<Journal> list() {
        @SuppressWarnings("unchecked")
        List<Journal> listJournals = (List<Journal>) sessionFactory.getCurrentSession()
                .createCriteria(Journal.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listJournals;
    }

    @Override
    @Transactional
    public Journal get(int id) {
        String hql = "from Journal where journal_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Journal> listJournal = (List<Journal>) query.list();

        if (listJournal != null && !listJournal.isEmpty()) {
            return listJournal.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Journal journal) {
        sessionFactory.getCurrentSession().saveOrUpdate(journal);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Journal journalToDelete = new Journal();
        journalToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(journalToDelete);

    }
}
