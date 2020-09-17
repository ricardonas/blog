package com.blog.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @GetMapping("/teste")
    public String teste(){
        return new String("testando");
    }
}
