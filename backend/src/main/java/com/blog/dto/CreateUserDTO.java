package com.blog.dto;

import com.blog.model.User;

public class CreateUserDTO {
    private String name;
    private String email;
    private String senha;

    public CreateUserDTO() {}

    public CreateUserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.senha = user.getSenha();
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
