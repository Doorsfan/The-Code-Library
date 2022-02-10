package com.example.CodeLibrary.entitites;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getImage() { return this.image; }

    public void setImage(String image) { this.image = image; }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String image;

    public User() {

    }

}
