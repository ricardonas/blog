package com.blog.resources;

import com.blog.dto.UserDTO;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<UserDTO> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).collect(Collectors.toList());
        return userDTOList;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
