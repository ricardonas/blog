package com.blog.dto;

import com.blog.model.Post;
import com.blog.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String email;
    private List<Post> postDTOList;

    public UserDTO() {}

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.postDTOList = user.getPosts();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPostList() {
        return postDTOList;
    }

    public void setPostList(List<Post> postList) {
        this.postDTOList = postList;
    }
}
