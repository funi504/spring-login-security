package com.security.security.model;

import jakarta.persistence.*;

@Entity
@Table(name="blackListedTokens")
public class BlackListedToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Integer tokenId;

    @Column(length = 2048, nullable = false, unique = true)
    private String token;

    public BlackListedToken() {
        super();
    }
    public BlackListedToken(Integer tokenId ,String token){
        this.token = token;
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }
}
