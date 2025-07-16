package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/email/**").permitAll() // ✅ allow public access
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // ✅ disable CSRF for testing APIs
                .oauth2Login(oauth -> oauth
                        .defaultSuccessUrl("http://localhost:5173/email", true)
                );

        return http.build();
    }
}
