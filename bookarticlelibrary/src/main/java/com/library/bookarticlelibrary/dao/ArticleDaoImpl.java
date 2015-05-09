/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.dao;

import com.library.bookarticlelibrary.model.Article;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ArticleDaoImpl() {

    }

    public ArticleDaoImpl(SessionFactory sessionFactory) {

    }

    @Override
    @Transactional
    public List<Article> list() {
        @SuppressWarnings("unchecked")
        List<Article> listArticles = (List<Article>) sessionFactory.getCurrentSession()
                .createCriteria(Article.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listArticles;
    }

    @Override
    @Transactional
    public Article get(int id) {
        String hql = "from Article where article_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Article> listArticle = (List<Article>) query.list();

        if (listArticle != null && !listArticle.isEmpty()) {
            return listArticle.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Article article) {
        sessionFactory.getCurrentSession().saveOrUpdate(article);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Article articleToDelete = new Article();
        articleToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(articleToDelete);

    }
}
