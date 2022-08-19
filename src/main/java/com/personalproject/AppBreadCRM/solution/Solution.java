package com.personalproject.AppBreadCRM.solution;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="Solution")
@Component
public class Solution {
    @Id
    @Column(name="ID", nullable = false, updatable = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name="TITLE", nullable = false)
    private String title;
    @Column(name="BODY", nullable = false)
    private String body;
    @Column(name="AUTHOR", nullable = false)
    private String author;

    @Column(name="DATE", nullable = false)
    private String publishDate;

    public Solution() {
    }

    public Solution(long id, String title, String body, String author, String publishDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.publishDate = publishDate;
    }

    public Solution(String title, String body, String author, String publishDate) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.publishDate = publishDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
