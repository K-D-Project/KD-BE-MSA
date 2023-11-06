package com.example.auth;

import com.example.auth.configuration.ApplicationConstant;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

@Entity
@RedisHash(value="refToken", timeToLive = ApplicationConstant.REFRESH_TOKEN_EXP / 1000 )
public class RefreshToken {

    @Id
    private String refToken;
    private String accessToken;

}
