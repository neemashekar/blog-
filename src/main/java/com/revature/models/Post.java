package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name="posts", schema="public")

public class Post {
    @Column(name="user_id")
    private Integer userId;
    @Column
    private String body;
    @Id
    @Column
    private Integer id;


    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    public Post() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", body='" + body + '\'' +
                ", id=" + id +
                ", user=" + user +
                '}';
    }
}
