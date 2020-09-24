package com.blog.resources;

import com.blog.dto.PostDTO;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDTO postDTO) {
        postService.createPost(postDTO);
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) {
        return postService.findPostById(id);
    }

    @GetMapping
    public List<PostDTO> getPosts() {
        return postService.getPosts();
    }

    @DeleteMapping("/{id}")
    public void deletePostByID(@PathVariable long id) {
        postService.deletePostById(id);
    }
}
