package com.HireHub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class AuthResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthResponse(String token) {
        this.token = token;
    }

    public AuthResponse() {
    }
}