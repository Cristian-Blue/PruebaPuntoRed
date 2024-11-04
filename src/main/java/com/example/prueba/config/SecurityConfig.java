package com.example.prueba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf-> csrf.disable())
            .cors(cors -> cors.configurationSource(addCorsMappings()))
            .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/auth").permitAll()
                        .requestMatchers("/api/*").authenticated()
                    .anyRequest().authenticated()
            )
                .addFilterBefore(tokenFilter(),  UsernamePasswordAuthenticationFilter.class)

        ;
        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource addCorsMappings() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000","http://127.0.0.1:3000","https://https://front-veci-fhd8.onrender.com")); // Ajusta el origen según tus necesidades
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}