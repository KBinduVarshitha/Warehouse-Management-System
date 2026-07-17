package com.wms.enterprisewms.config;


import com.wms.enterprisewms.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class SecurityConfig {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;



    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter){

        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }




    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {



        http

            .csrf(csrf -> csrf.disable())


            .authorizeHttpRequests(auth -> auth


                    // Authentication APIs are public
                    .requestMatchers("/api/auth/**")
                    .permitAll()


                    // Admin access
                    .requestMatchers("/api/products/**")
                    .hasRole("ADMIN")


                    // Admin + Operator
                    .requestMatchers("/api/orders/**")
                    .hasAnyRole(
                            "ADMIN",
                            "OPERATOR"
                    )


                    .anyRequest()
                    .authenticated()

            )


            .sessionManagement(session ->
                    session.sessionCreationPolicy(
                            SessionCreationPolicy.STATELESS
                    )
            )



            .addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
            );



        return http.build();

    }




    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }




    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {


        return configuration.getAuthenticationManager();

    }

}