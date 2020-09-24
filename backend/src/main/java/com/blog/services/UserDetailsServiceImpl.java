package com.blog.services;

import com.blog.exception.NotFoundException;
import com.blog.model.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) {
        User user = userRepository.findByEmail(id);
        if ( user == null )
            throw new NotFoundException("Usuário não existe");
        return user;
    }
}
