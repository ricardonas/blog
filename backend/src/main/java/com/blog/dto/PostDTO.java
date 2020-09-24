package com.blog.dto;

import com.blog.model.Post;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String text;
    private LocalDateTime post_date;
    private long userId;

    public PostDTO() {}

    public PostDTO(Post post) {
        this.title = post.getTitle();
        this.text = post.getText();
        this.userId = post.getUser().getId();
        post_date = post.getPost_date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPost_date() {
        return post_date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
