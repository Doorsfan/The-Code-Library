package com.example.CodeLibrary.DTOs;

public class UserWithoutPW {
    String username, profileURL;

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

    @Override
    public String toString() {
        return "UserWithoutPW{" +
                "username='" + username + '\'' +
                ", profileURL='" + profileURL + '\'' +
                '}';
    }

    public UserWithoutPW(String username, String profileURL){
        this.username = username;
        this.profileURL = profileURL;
    }
}
