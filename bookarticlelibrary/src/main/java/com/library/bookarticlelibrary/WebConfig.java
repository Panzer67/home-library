/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary;

import com.library.bookarticlelibrary.dao.ArticleDao;
import com.library.bookarticlelibrary.dao.ArticleDaoImpl;
import com.library.bookarticlelibrary.dao.AuthorDao;
import com.library.bookarticlelibrary.dao.AuthorDaoImpl;
import com.library.bookarticlelibrary.dao.BookDao;
import com.library.bookarticlelibrary.dao.BookDaoImpl;
import com.library.bookarticlelibrary.dao.JournalDao;
import com.library.bookarticlelibrary.dao.JournalDaoImpl;
import com.library.bookarticlelibrary.model.Article;
import com.library.bookarticlelibrary.model.Author;
import com.library.bookarticlelibrary.model.Book;
import com.library.bookarticlelibrary.model.Journal;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.library.bookarticlelibrary")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/view/**").addResourceLocations("WEB-INF/view");
    }

    @Bean(name = "usersdb")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/usersdb");
        dataSource.setUsername("root");
        dataSource.setPassword("Welkom01");

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory1(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClasses(Book.class, Article.class, Author.class, Journal.class);

        return sessionBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }
    
    @Autowired
    @Bean(name = "bookDao")
    public BookDao getBookDao(SessionFactory sessionFactory) {
        return new BookDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "articleDao")
    public ArticleDao getArticleDao(SessionFactory sessionFactory) {
        return new ArticleDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "authorDao")
    public AuthorDao getAuthorDao(SessionFactory sessionFactory) {
        return new AuthorDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "journalDao")
    public JournalDao getJournalDao(SessionFactory sessionFactory) {
        return new JournalDaoImpl(sessionFactory);
    }

}
