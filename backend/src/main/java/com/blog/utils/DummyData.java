package com.blog.utils;

import com.blog.model.Post;
import com.blog.model.Profile;
import com.blog.model.User;
import com.blog.repository.PostRepository;
import com.blog.repository.ProfileRepository;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class DummyData {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ProfileRepository profileRepository;

    //@PostConstruct
    public void saveUserAndPosts() {
        User ricardo = new User("Ricardo", "ricardo@gmail.com", "123456");
        userRepository.save(ricardo);

        Profile profile = new Profile("ADMIN");
        profileRepository.save(profile);

        Post post1 = new Post("Space X", "Lançamento de foguetes da space x", ricardo);
        postRepository.save(post1);

        ricardo.setProfiles(Collections.singletonList(profile));
        ricardo.setPosts(Collections.singletonList(post1));
    }

}
