package com.security.security.DTO;

import com.security.security.model.ApplicationUser;

public class LoginResponseDTO {
    private ApplicationUser user;
    private String jwt;
    
    public LoginResponseDTO(){
        super();
    }
    public LoginResponseDTO(ApplicationUser user, String jwt){
        this.jwt=jwt;
        this.user = user;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
