/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.model;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "ARTICLES")
public class Article implements Serializable, Comparable<Article> {

    @Id
    @GeneratedValue
    @Column(name = "ARTICLE_ID")
    private int id;

    private int journal_id;

    @NotEmpty
    private String title;

    private int volume;

    private int issue;

    private int year;

    @NotEmpty
    private String pages;

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "authors_articles", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> articleAuthors;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "JOURNAL_ID")
    private Journal journal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(int journal_id) {
        this.journal_id = journal_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public List<Author> getAuthors() {
        return articleAuthors;
    }

    public void setAuthors(List<Author> articleAuthors) {
        this.articleAuthors = articleAuthors;
    }

    @Override
    public int compareTo(Article article) {
        return title.compareTo(article.getTitle());
    }
}
