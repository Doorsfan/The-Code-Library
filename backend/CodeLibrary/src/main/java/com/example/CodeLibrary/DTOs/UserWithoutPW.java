package com.example.CodeLibrary.DTOs;

public class UserWithoutPW {
    String username, profileURL;
    Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserWithoutPW{" +
                "username='" + username + '\'' +
                ", profileURL='" + profileURL + '\'' +
                ", id=" + id +
                '}';
    }

    public UserWithoutPW(Integer id, String username, String profileURL){
        this.id = id;
        this.username = username;
        this.profileURL = profileURL;
    }
}
