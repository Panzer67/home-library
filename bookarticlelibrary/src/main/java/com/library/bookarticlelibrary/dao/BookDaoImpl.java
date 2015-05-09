
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Book;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public BookDaoImpl() {

    }

    public BookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Book> list() {
        @SuppressWarnings("unchecked")
        List<Book> listBook = (List<Book>) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listBook;
    }

    @Override
    @Transactional
    public Book get(int id) {
        String hql = "from Book where book_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Book> listBook = (List<Book>) query.list();

        if (listBook != null && !listBook.isEmpty()) {
            return listBook.get(0);
        }

        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Book book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Book bookToDelete = new Book();
        bookToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(bookToDelete);

    }
}
