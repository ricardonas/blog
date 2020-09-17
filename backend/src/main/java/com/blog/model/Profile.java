package com.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String type;

    public Profile() {
    }

    public Profile(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return this.type;
    }
}
