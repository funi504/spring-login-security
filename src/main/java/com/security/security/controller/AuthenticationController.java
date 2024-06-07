package com.security.security.controller;

import com.security.security.DTO.LoginResponseDTO;
import com.security.security.DTO.RegistrationDTO;
import com.security.security.model.ApplicationUser;
import com.security.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){

        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    //since registration and login both take only username and password... should have login DTO
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){

        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
