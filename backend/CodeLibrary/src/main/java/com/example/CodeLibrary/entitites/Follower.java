package com.example.CodeLibrary.entitites;

import javax.persistence.*;

@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String followersusername;
    String targetusername;

    public Follower() {
    }

    public String getFollowersusername() {
        return followersusername;
    }

    public void setFollowersusername(String followersusername) {
        this.followersusername = followersusername;
    }

    public String getTargetusername() {
        return targetusername;
    }

    public void setTargetusername(String targetusername) {
        this.targetusername = targetusername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "id=" + id +
                ", followersusername='" + followersusername + '\'' +
                ", targetusername='" + targetusername + '\'' +
                '}';
    }

}
