package com.security.security.controller;

import com.security.security.DTO.LoginResponseDTO;
import com.security.security.DTO.LogoutDTO;
import com.security.security.DTO.RegistrationDTO;
import com.security.security.model.ApplicationUser;
import com.security.security.service.AuthenticationService;
import com.security.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    public TokenService tokenService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){

        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    //since registration and login both take only username and password... should have login DTO
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){

        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/logout")
    public LogoutDTO logout(@RequestHeader("Authorization") String token) {

        return authenticationService.logoutUser(token);
    }
}
