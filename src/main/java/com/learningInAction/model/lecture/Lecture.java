package com.learningInAction.model.lecture;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lecture {
    /*================================================= FIELDS =======================================================*/
    /*id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*Identifications*/
    private Thyme parent;
    private int levelLecture;
    private int expUpp;
    private int peerCost;
    /*Lecture fields*/
    private String title;
    private String img;
    private String anons;
    private String body;
    /*Video*/
    private String video;
    /*Tasks*/

    /*================================================= CONSTRUCTORS =================================================*/
    public Lecture() {}
    /*================================================= GETTERS ======================================================*/
    public Long getId() { return id; }
    public Thyme getParent() { return parent; }
    public int getLevelLecture() { return levelLecture; }
    public int getExpUpp() { return expUpp; }
    public String getTitle() { return title; }
    public String getAnons() { return anons; }
    public String getBody() { return body; }
    public String getImg() { return img; }
    public String getVideo() { return video; }

    /*================================================= SETTERS ======================================================*/
    public void setId(Long id) { this.id = id; }
    public void setParent(Thyme parent) { this.parent = parent; }
    public void setLevelLecture(int levelLecture) { this.levelLecture = levelLecture; }
    public void setExpUpp(int expUpp) { this.expUpp = expUpp; }
    public void setTitle(String title) { this.title = title; }
    public void setAnons(String anons) { this.anons = anons; }
    public void setBody(String body) { this.body = body; }
    public void setImg(String img) { this.img = img; }
    public void setVideo(String video) { this.video = video; }
    /*================================================= SYSTEM =======================================================*/
    /*================================================= METHODS ======================================================*/


}
