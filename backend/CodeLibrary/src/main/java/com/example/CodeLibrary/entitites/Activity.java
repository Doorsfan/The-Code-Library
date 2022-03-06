package com.example.CodeLibrary.entitites;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String event;
    Timestamp timestamp;
    String username;
    String authorurl;
    Integer articleid;
    String followeduser;

    public Activity() {
    }

    public String getFolloweduser() {
        return followeduser;
    }

    public void setFolloweduser(String followeduser) {
        this.followeduser = followeduser;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", timestamp=" + timestamp +
                ", username='" + username + '\'' +
                ", authorurl='" + authorurl + '\'' +
                ", articleid=" + articleid +
                ", followeduser='" + followeduser + '\'' +
                '}';
    }

    public String getAuthorurl() {
        return authorurl;
    }

    public void setAuthorurl(String authorurl) {
        this.authorurl = authorurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }


}
