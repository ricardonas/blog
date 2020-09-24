package com.blog.resources;

import com.blog.dto.CreateUserDTO;
import com.blog.dto.PostDTO;
import com.blog.dto.UserDTO;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public UserDTO getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable long id) throws Exception {
         userService.deleteById(id);
    }
}
