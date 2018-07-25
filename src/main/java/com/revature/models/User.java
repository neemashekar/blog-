package com.revature.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users", schema="public")
public class User {

    private String username;

    private String password;

    private Integer id;

    private List<Post> posts;

    public User() {
    }

    @Column(name= "username", nullable=false, unique=true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name= "password", nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy="user")
    @ElementCollection(targetClass = Post.class)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
