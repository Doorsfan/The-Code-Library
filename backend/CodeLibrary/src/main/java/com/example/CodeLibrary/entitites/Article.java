package com.example.CodeLibrary.entitites;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maintitle;
    private String author;
    private String firsttag;
    private String secondtag;
    private String thirdtag;
    private String firstprerequisite;
    private String secondprerequisite;
    private String thirdprerequisite;
    private String difficulty;
    private String language;
    private String firstdescription;
    private String firsttitle;
    private String firstsection;
    private String seconddescription;
    private String secondtitle;
    private String secondsection;
    private String thirddescription;
    private String thirdtitle;
    private String thirdsection;
    private Timestamp timestamp;
    private Integer likes;
    private Integer dislikes;
    private Integer comments;
    private String authorimage;

    public Article() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmaintitle() {
        return maintitle;
    }

    public void setmaintitle(String maintitle) {
        this.maintitle = maintitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFirsttag() {
        return firsttag;
    }

    public void setFirsttag(String firsttag) {
        this.firsttag = firsttag;
    }

    public String getSecondtag() {
        return secondtag;
    }

    public void setSecondtag(String secondtag) {
        this.secondtag = secondtag;
    }

    public String getThirdtag() {
        return thirdtag;
    }

    public void setThirdtag(String thirdtag) {
        this.thirdtag = thirdtag;
    }

    public String getFirstprerequisite() {
        return firstprerequisite;
    }

    public void setFirstprerequisite(String firstprerequisite) {
        this.firstprerequisite = firstprerequisite;
    }

    public String getSecondprerequisite() {
        return secondprerequisite;
    }

    public void setSecondprerequisite(String secondprerequisite) {
        this.secondprerequisite = secondprerequisite;
    }

    public String getThirdprerequisite() {
        return thirdprerequisite;
    }

    public void setThirdprerequisite(String thirdprerequisite) {
        this.thirdprerequisite = thirdprerequisite;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFirstdescription() {
        return firstdescription;
    }

    public void setFirstdescription(String firstdescription) {
        this.firstdescription = firstdescription;
    }

    public String getFirsttitle() {
        return firsttitle;
    }

    public void setFirsttitle(String firsttitle) {
        this.firsttitle = firsttitle;
    }

    public String getFirstsection() {
        return firstsection;
    }

    public void setFirstsection(String firstsection) {
        this.firstsection = firstsection;
    }

    public String getSeconddescription() {
        return seconddescription;
    }

    public void setSeconddescription(String seconddescription) {
        this.seconddescription = seconddescription;
    }

    public String getSecondtitle() {
        return secondtitle;
    }

    public void setSecondtitle(String secondtitle) {
        this.secondtitle = secondtitle;
    }

    public String getSecondsection() {
        return secondsection;
    }

    public void setSecondsection(String secondsection) {
        this.secondsection = secondsection;
    }

    public String getThirddescription() {
        return thirddescription;
    }

    public void setThirddescription(String thirddescription) {
        this.thirddescription = thirddescription;
    }

    public String getThirdtitle() {
        return thirdtitle;
    }

    public void setThirdtitle(String thirdtitle) {
        this.thirdtitle = thirdtitle;
    }

    public String getThirdsection() {
        return thirdsection;
    }

    public void setThirdsection(String thirdsection) {
        this.thirdsection = thirdsection;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getAuthorimage() {
        return authorimage;
    }

    public void setAuthorimage(String authorimage) {
        this.authorimage = authorimage;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", maintitle='" + maintitle + '\'' +
                ", author='" + author + '\'' +
                ", firsttag='" + firsttag + '\'' +
                ", secondtag='" + secondtag + '\'' +
                ", thirdtag='" + thirdtag + '\'' +
                ", firstprerequisite='" + firstprerequisite + '\'' +
                ", secondprerequisite='" + secondprerequisite + '\'' +
                ", thirdprerequisite='" + thirdprerequisite + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", language='" + language + '\'' +
                ", firstdescription='" + firstdescription + '\'' +
                ", firsttitle='" + firsttitle + '\'' +
                ", firstsection='" + firstsection + '\'' +
                ", seconddescription='" + seconddescription + '\'' +
                ", secondtitle='" + secondtitle + '\'' +
                ", secondsection='" + secondsection + '\'' +
                ", thirddescription='" + thirddescription + '\'' +
                ", thirdtitle='" + thirdtitle + '\'' +
                ", thirdsection='" + thirdsection + '\'' +
                ", timestamp=" + timestamp +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", comments=" + comments +
                ", authorimage='" + authorimage + '\'' +
                '}';
    }

}
