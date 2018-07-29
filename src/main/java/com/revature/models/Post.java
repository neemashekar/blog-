package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name="posts", schema="public")
public class Post {

    private String body;

    private String title;

    private Integer id;

    private User user;

    public Post() {
    }

    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Id
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "body='" + body + '\'' +
                ", id=" + id +
                ", user=" + user +
                '}';
    }
}
