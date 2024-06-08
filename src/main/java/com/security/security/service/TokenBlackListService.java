package com.security.security.service;

import com.security.security.model.BlackListedToken;
import com.security.security.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenBlackListService {

    @Autowired
    public TokenRepository tokenRepository;

    public boolean isTokenBlackListed(String token){

        return tokenRepository.findByToken(token).isPresent();
    }

    public void blackListToken(String token){

        tokenRepository.save( new BlackListedToken(0, token));
    }
}
