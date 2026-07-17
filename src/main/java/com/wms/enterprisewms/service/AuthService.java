package com.wms.enterprisewms.service;


import com.wms.enterprisewms.dto.*;
import com.wms.enterprisewms.entity.Role;
import com.wms.enterprisewms.entity.User;
import com.wms.enterprisewms.repository.UserRepository;
import com.wms.enterprisewms.security.JwtService;


import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;



@Service
public class AuthService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;



    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager){


        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;

        this.jwtService = jwtService;

        this.authenticationManager = authenticationManager;

    }





    public String register(RegisterRequest request){


        User user = new User();


        user.setUsername(
                request.getUsername()
        );


        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );


        user.setRole(
                request.getRole()
        );


        userRepository.save(user);



        return "User registered successfully";

    }





    public String login(LoginRequest request){


        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getUsername(),

                        request.getPassword()

                )

        );



        return jwtService.generateToken(
                request.getUsername()
        );

    }

}