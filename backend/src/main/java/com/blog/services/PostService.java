package com.blog.services;

import com.blog.dto.PostDTO;
import com.blog.exception.NotFoundException;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.PostRepository;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public void createPost(PostDTO postDTO) {
        Post post = new Post();

        Optional<User> optionalUser = userRepository.findById(postDTO.getUserId());
        User user = optionalUser.orElse(null);

        post.setTitle(postDTO.getTitle());
        post.setText(postDTO.getText());
        post.setUser(user);

        postRepository.save(post);
        Objects.requireNonNull(user).getPosts().add(post);
    }

    public List<PostDTO> getPosts() {
        List<Post> postList = postRepository.findAll();
        return postList.stream().map(PostDTO::new).collect(Collectors.toList());
    }

    public PostDTO findPostById(long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if ( ! optionalPost.isPresent() ) { throw new NotFoundException("Post não encontrado"); }
        return new PostDTO(optionalPost.get());
    }

    public void deletePostById(long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if ( ! optionalPost.isPresent() ) { throw new NotFoundException("Post não encontrado"); }
        postRepository.deleteById(id);
    }
}
