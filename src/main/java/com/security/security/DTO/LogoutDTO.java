package com.security.security.DTO;

import com.security.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class LogoutDTO {

    private String token;

    public LogoutDTO(){
        super();
    }
    public LogoutDTO(String token){
        this.token=token;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
