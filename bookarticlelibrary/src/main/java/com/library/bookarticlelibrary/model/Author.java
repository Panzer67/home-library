/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "AUTHORS")
public class Author implements Serializable, Comparable<Author> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private int id;

    @NotEmpty
    @Column(name = "AUTHOR_FIRSTNAME")
    private String firstname;

    @NotEmpty
    @Column(name = "AUTHOR_LASTNAME")
    private String lastname;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "articleAuthors")
    private List<Article> articles;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "bookAuthors", fetch = FetchType.EAGER)
    private List<Book> books;

    /*
     @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinTable(name = "authors_articles", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))	
     private List<Article> authorArticles;
     */
    /*
     @ManyToMany(cascade = CascadeType.ALL)
     @LazyCollection(LazyCollectionOption.FALSE)
     @JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))    
     private List<Book> authorBooks;
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /*
     Comparator<Author> compareFirstName = new Comparator<Author>(){
     public int compare(Author a, Author b){
     return a.getFirstname().compareTo(b.getFirstname());
     }
	
     };
     */
    @Override
    public int compareTo(Author author) {
        return lastname.compareTo(author.getLastname());
    }
}
