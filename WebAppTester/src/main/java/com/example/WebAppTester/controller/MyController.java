package com.example.WebAppTester.controller;

import com.example.WebAppTester.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Step 1: Annotate the class as @Controller to mark it as a Spring MVC controller
@Controller
public class MyController {

    // Step 2: Declare a private field for UserService and annotate it with @Autowired
    @Autowired
    private UserService userService;

    // Step 3: Define a method to handle the /register GET request and return the register view
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // This should match the name of the HTML file in the templates directory
    }

    // Step 4: Handle user registration
    // Step 4a: Create a method to handle the /register POST request
    @PostMapping("/register")
    public String registerUser(
            // Step 4b: Use @RequestParam to capture the username and password from the form
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        // Step 4c: Call the registerUser method from UserService to save the user
        userService.registerUser(username, password);

        // Step 4d: Redirect to the /login page after successful registration
        return "redirect:/login";
    }

    // Step 5: Define a method to handle the /login GET request and return the login view
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This should match the name of the HTML file in the templates directory
    }

    // Step 6: Define a method to handle the /welcome GET request and return the welcome view
    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome"; // This should match the name of the HTML file in the templates directory
    }
}
