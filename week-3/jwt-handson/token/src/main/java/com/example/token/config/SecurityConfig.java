package com.example.token.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF as we are using stateless JWTs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/authenticate").permitAll() // Allow public access to auth endpoint
                .anyRequest().authenticated()                // Protect everything else
            );
            
        return http.build();
    }
}