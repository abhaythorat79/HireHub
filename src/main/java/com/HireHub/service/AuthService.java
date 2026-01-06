package com.HireHub.service;

import com.HireHub.dto.LoginRequest;
import com.HireHub.dto.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);
    String login(LoginRequest request);

}
