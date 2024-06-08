package com.security.security.service;

import com.security.security.model.BlackListedToken;
import com.security.security.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class TokenService {



    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    public JwtDecoder jwtDecoder;

    public String genarateJwt(Authentication auth){

        Instant now = Instant.now();

        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet.Builder builder = JwtClaimsSet.builder();
        builder.issuer("self");
        builder.issuedAt(now);
        builder.subject(auth.getName());
        builder.claim("roles", scope);
        JwtClaimsSet claimsSet = builder
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }


}
