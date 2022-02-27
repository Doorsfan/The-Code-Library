package com.example.CodeLibrary.entitites;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "shownnotification")
public class ShownNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String content;
    String authorname;
    String authorurl;
    String showntousername;
    Timestamp timestamp;
    Integer articleid;

    public ShownNotification() {
    }

    @Override
    public String toString() {
        return "ShownNotification{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", authorname='" + authorname + '\'' +
                ", authorurl='" + authorurl + '\'' +
                ", showntousername='" + showntousername + '\'' +
                ", timestamp=" + timestamp +
                ", articleid=" + articleid +
                '}';
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getshowntousername() {
        return showntousername;
    }

    public void setShownToUsername(String showntousername) {
        this.showntousername = showntousername;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorurl() {
        return authorurl;
    }

    public void setAuthorurl(String authorurl) {
        this.authorurl = authorurl;
    }


}
