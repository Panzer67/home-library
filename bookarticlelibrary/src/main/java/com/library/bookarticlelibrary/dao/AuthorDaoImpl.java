/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Author;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public AuthorDaoImpl() {

    }

    public AuthorDaoImpl(SessionFactory sessionFactory) {

    }

    @Override
    @Transactional
    public List<Author> list() {

        @SuppressWarnings("unchecked")
        List<Author> listAuthors = (List<Author>) sessionFactory.getCurrentSession()
                .createCriteria(Author.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listAuthors;
    }

    @Override
    @Transactional
    public Author get(int id) {
        String hql = "from Author where author_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Author> listAuthor = (List<Author>) query.list();

        if (listAuthor != null && !listAuthor.isEmpty()) {
            return listAuthor.get(0);
        }
        return null;

    }

    @Override
    @Transactional
    public Author getAuthorByName(String firstname, String lastname) {
        String hql = "from Author where author_firstname='" + firstname + "' and author_lastname='" + lastname + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Author> listAuthor = (List<Author>) query.list();
        if (listAuthor != null && !listAuthor.isEmpty()) {
            return listAuthor.get(0);
        }
        Author author = new Author();
        author.setFirstname(firstname);
        author.setLastname(lastname);

        return author;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Author author) {
        sessionFactory.getCurrentSession().saveOrUpdate(author);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Author authorToDelete = new Author();
        authorToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(authorToDelete);

    }
}
