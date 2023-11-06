package com.example.auth.service;

import com.example.auth.KDRoleRepository;
import com.example.auth.KDUser;
import com.example.auth.KDUserRepository;
import com.example.auth.RefreshTokenRepository;
import com.example.auth.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final JwtUtils jwtUtils;
    private final KDUserRepository kdUserRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public Map<String, String> generateKeySetFromUserId(String userId) {

        return null;
    }

    @Override
    public Map<String, String> refreshKeySetFromUserId(String userId) {
        return null;
    }

    @Override
    public boolean validateAccessToken(String accessToken) {
        return jwtUtils.introspectJwt(accessToken);
    }

    @Override
    public boolean validateRefreshToken(String refreshToken) {
        return refreshTokenRepository.findById(refreshToken).isPresent();
    }

}
