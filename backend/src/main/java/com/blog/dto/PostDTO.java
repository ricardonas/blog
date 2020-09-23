package com.blog.dto;

import com.blog.model.Post;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String text;
    private LocalDateTime post_date;

    public PostDTO() {}

    public PostDTO(Post post) {
        id = post.getId();
        title = post.getTitle();
        text = post.getText();
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

    public void setPost_date(LocalDateTime post_date) {
        this.post_date = post_date;
    }

    public long getId() {
        return id;
    }
}
