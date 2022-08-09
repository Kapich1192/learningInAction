package com.learningInAction.model.news;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;

@Entity
public class News {
    /*================================================= FIELDS =======================================================*/
    /*id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*fields*/
    private String title;
    private String anons;
    private String img;
    private String bodyNews;
    private String body;
    /*================================================= GETTERS ======================================================*/
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAnons() { return anons; }
    public String getImg() { return img; }
    public String getBodyNews() { return bodyNews; }
    public String getBody() { return body; }
    /*================================================= SETTERS ======================================================*/
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAnons(String anons) { this.anons = anons; }
    public void setImg(String img) { this.img = img; }
    public void setBodyNews(String bodyNews) { this.bodyNews = bodyNews; }
    public void setBody(String body) { this.body = body; }
}
