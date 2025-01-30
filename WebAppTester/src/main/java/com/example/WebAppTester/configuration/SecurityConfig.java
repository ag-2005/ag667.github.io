package com.example.WebAppTester.configuration;

import com.example.WebAppTester.service.UserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Step 1: Annotate the class as @Configuration
// This marks the class as a source of Spring configuration
@Configuration
// Step 2: Add @EnableWebSecurity to enable Spring Security for the application
@EnableWebSecurity
public class SecurityConfig {

    // Step 3: Create a private final field called userDetails
    private final UserDetails userDetails;

    // Step 4: Use constructor injection to pass the custom UserDetails object
    public SecurityConfig(UserDetails customUserDetails) {
        this.userDetails = customUserDetails;
    }

    // Step 5: Define the Security Filter Chain
    // The @Bean annotation tells Spring to manage this method as a bean
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity during development
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/register", "/login").permitAll() // Allow register and login
                                .anyRequest().authenticated() // Restrict all other endpoints
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/welcome", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );
        return http.build();
    }


    // Step 11 (extra step): Define PasswordEncoder as a bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
