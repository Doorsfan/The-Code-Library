package com.example.CodeLibrary.entitites;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleid;
    }

    public void setArticleId(Integer articleId) {
        this.articleid = articleId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public Integer getarticleid() {
        return articleid;
    }

    public void setarticleid(Integer articleid) {
        this.articleid = articleid;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", articleid=" + articleid +
                ", userid=" + userid +
                '}';
    }

    Integer articleid;
    Integer userid;

    public Like() {}


}
