package com.wms.enterprisewms.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class JwtService {


    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey12345";


    private final long EXPIRATION_TIME = 
            1000 * 60 * 60; // 1 hour



    private Key getSigningKey(){

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }



    // Generate JWT Token
    public String generateToken(String username){


        return Jwts.builder()

                .setSubject(username)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                + EXPIRATION_TIME
                        )
                )

                .signWith(
                        getSigningKey(),
                        SignatureAlgorithm.HS256
                )

                .compact();
    }




    // Extract username from token
    public String extractUsername(String token){

        return Jwts.parserBuilder()

                .setSigningKey(getSigningKey())

                .build()

                .parseClaimsJws(token)

                .getBody()

                .getSubject();
    }





    // Validate token
    public boolean validateToken(String token){

        try{

            Jwts.parserBuilder()

                    .setSigningKey(getSigningKey())

                    .build()

                    .parseClaimsJws(token);


            return true;

        }
        catch(Exception e){

            return false;
        }
    }

}