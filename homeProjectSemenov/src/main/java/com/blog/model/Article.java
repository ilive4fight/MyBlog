package com.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by semen on 14.04.2016.
 */
@Entity
@Table(name = "APP_ARTICLE")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("articleId")
    private int id;
    @Column(name="TITLE",  nullable=false)
    @JsonProperty("title")
    private String title;
    @Column(name="TEXT",  nullable=false)
    @JsonProperty("text")
    private String text;

    public Article()
    {
    }
    public Article(String title, String text)
    {
        this.title = title;
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
       this.user=user;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {return text;}
    public void setText(String text) {this.text = text;}
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text=" + text +
                '}';
    }
}