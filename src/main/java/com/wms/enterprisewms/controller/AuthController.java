package com.wms.enterprisewms.controller;


import com.wms.enterprisewms.dto.LoginRequest;
import com.wms.enterprisewms.dto.RegisterRequest;
import com.wms.enterprisewms.service.AuthService;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {



    private final AuthService authService;



    public AuthController(AuthService authService){

        this.authService = authService;

    }




    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request){


        return ResponseEntity.ok(
                authService.register(request)
        );

    }





    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request){


        return ResponseEntity.ok(
                authService.login(request)
        );

    }

}