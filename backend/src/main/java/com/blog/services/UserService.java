package com.blog.services;

import com.blog.dto.CreateUserDTO;
import com.blog.dto.UserDTO;
import com.blog.exception.NotFoundException;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setEmail(createUserDTO.getEmail());
        user.setName(createUserDTO.getName());
        user.setSenha(createUserDTO.getSenha());
        userRepository.save(user);
    }

    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public void deleteById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if ( ! optionalUser.isPresent() ) { throw new NotFoundException("Usuário não encontrado"); }
        userRepository.deleteById(id);
    }

    public UserDTO getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if ( ! optionalUser.isPresent() ) { throw new NotFoundException("Usuário não encontrado"); }
        return new UserDTO(optionalUser.get());
    }
}
