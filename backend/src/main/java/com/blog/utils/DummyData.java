package com.blog.utils;

import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void createUser() {
        User user1 = new User("Ricardo", "ricardocontato@gmail.com", "123456789");

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post("Inteligência Artificial", "Lorem Ipsum", user1);
        Post post2 = new Post("Business Inteligence", "Lorem Ipsum", user1);

        postList.add(post1);
        postList.add(post2);

        user1.setPosts(postList);

        userRepository.save(user1);
    }
}
