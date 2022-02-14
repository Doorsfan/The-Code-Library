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
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userid=" + userid +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer articleId;
    Integer userid;

    public Like() {}


}
