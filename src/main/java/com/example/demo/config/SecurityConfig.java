package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Swagger URLs
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // Auth endpoints
                .requestMatchers("/auth/**").permitAll()

                // Application REST APIs (ALLOW FOR SWAGGER TESTING)
                .requestMatchers(
                    "/vehicle/**",
                    "/vehicles/**",
                    "/shipments/**",
                    "/locations/**",
                    "/optimize/**",
                    "/route-result/**"
                ).permitAll()

                // Any other request
                .anyRequest().authenticated()
            )

            // No login form / basic auth popup
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}