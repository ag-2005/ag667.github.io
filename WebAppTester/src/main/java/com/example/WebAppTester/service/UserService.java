package com.example.WebAppTester.service;

import com.example.WebAppTester.model.User;
import com.example.WebAppTester.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Step 2: Annotate this class as @Service to define it as a Spring-managed service
@Service
public class UserService {

    // Step 3: Create a repository object called userRepository and mark it as private
    @Autowired
    private UserRepository userRepository;

    // Step 4: Create a private object called passwordEncoder, annotated with @Autowired
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Step 5: Create a constructor for UserService
    // This initializes the userRepository object using dependency injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Step 6: Create a public method called registerUser
    public void registerUser(String username, String password) {
        // Step 7: Instantiate a User object
        User user = new User();

        // Step 8: Assign the username parameter to the user object's username property
        user.setUsername(username);

        // Step 9: Use the passwordEncoder bean to encode the password and set it in the user object
        user.setPassword(passwordEncoder.encode(password));

        // Step 10: Assign a default role to the user object
        user.setRole("USER");

        // Step 11: Use the userRepository to save the user object to the database
        userRepository.save(user);
    }
}

