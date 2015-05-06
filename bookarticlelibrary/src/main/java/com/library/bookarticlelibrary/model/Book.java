/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "BOOKS")
public class Book implements Serializable, Comparable<Book>{

    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private int id;

    //@Pattern(regexp="(^$|[0-9]{13})")
    private String isbn;

    @NotEmpty
    private String title;

    @NotEmpty
    private String publisher;

    /*
     @LazyCollection(LazyCollectionOption.FALSE)
     @ManyToMany(mappedBy = "authorBooks",  cascade = CascadeType.ALL)
     private List<Author> authors;	
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> bookAuthors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return bookAuthors;
    }

    public void setAuthors(List<Author> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    @Override
    public int compareTo(Book book) {
        return title.compareTo(book.getTitle());
    }
}
