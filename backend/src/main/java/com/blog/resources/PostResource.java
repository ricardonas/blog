package com.blog.resources;

import com.blog.dto.PostDTO;
import com.blog.model.Post;
import com.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    PostRepository postRepository;

    @GetMapping
    public List<PostDTO> findAll() {
        List<Post> postList = postRepository.findAll();
        return postList.stream().map(PostDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public void deleteById(@PathVariable("id") long id ) {
        postRepository.deleteById(id);
    }

    @PostMapping
    public void createPost(Post post) {
        postRepository.save(post);
    }

}
