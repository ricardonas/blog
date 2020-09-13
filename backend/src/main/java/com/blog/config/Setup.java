package com.blog.config;

import com.blog.model.Post;
import com.blog.model.Profile;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

public class Setup implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Maria", "maria@maria.com", "$2y$12$uEZIr6U9qYHVD69rwoIlxu57HmHhO4aGc4rpvzGrAhsM8KP4xf16i");

        List<Post> postList = new ArrayList<>();
        postList.add(new Post("Titulo", "Texto", user));
        postList.add(new Post("Titulo teste", "Texto teste", user));

        List<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile("ADMIN"));

        user.setPosts(postList);
        user.setProfiles(profileList);

        userRepository.save(user);
    }
}
