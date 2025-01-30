package com.example.WebAppTester.service;

import com.example.WebAppTester.model.User;
import com.example.WebAppTester.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetails implements UserDetailsService {

    //create field for constructor dependency injection for repository
    private final UserRepository userRepository;

    //constructor for repository
    public UserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //retrieve data method

    //create method
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //find user by username using repository
        User user = userRepository.findByUsername(username);

        //handle if user is not found
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        //return data
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
