package com.example.CodeLibrary.entitites;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String content;
    String authorname;
    String authorurl;
    private Timestamp timestamp;

    public Notification() {
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

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", authorname='" + authorname + '\'' +
                ", authorurl='" + authorurl + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
