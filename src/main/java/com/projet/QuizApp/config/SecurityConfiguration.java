package com.projet.QuizApp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.projet.QuizApp.user.Permission.ADMIN_CREATE;
import static com.projet.QuizApp.user.Permission.ADMIN_DELETE;
import static com.projet.QuizApp.user.Permission.ADMIN_READ;
import static com.projet.QuizApp.user.Permission.ADMIN_UPDATE;
import static com.projet.QuizApp.user.Permission.MANAGER_CREATE;
import static com.projet.QuizApp.user.Permission.MANAGER_DELETE;
import static com.projet.QuizApp.user.Permission.MANAGER_READ;
import static com.projet.QuizApp.user.Permission.MANAGER_UPDATE;
import static com.projet.QuizApp.user.Role.ADMIN;
import static com.projet.QuizApp.user.Role.MANAGER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {


    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/**").permitAll()
                );

        return http.build();
    }
}
