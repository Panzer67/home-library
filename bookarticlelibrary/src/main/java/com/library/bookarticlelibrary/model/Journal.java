/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.bookarticlelibrary.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOURNALS")
public class Journal implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "JOURNAL_ID")
    private int journal_id;

    private String journal_name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "journal")
    private List<Article> articles;

    public int getId() {
        return journal_id;
    }

    public void setId(int journal_id) {
        this.journal_id = journal_id;
    }

    public String getJournal_name() {
        return journal_name;
    }

    public void setJournal_name(String journal_name) {
        this.journal_name = journal_name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
