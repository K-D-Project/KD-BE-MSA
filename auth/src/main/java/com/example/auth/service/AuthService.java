package com.example.auth.service;

import lombok.RequiredArgsConstructor;

import java.util.Map;

public interface AuthService {

    public Map<String, String> generateKeySetFromUserId(String userId);
    public Map<String, String> refreshKeySetFromUserId(String userId);
    public boolean validateAccessToken(String accessToken);
    public boolean validateRefreshToken(String refreshToken);

}
