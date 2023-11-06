package com.example.auth.utils;

import com.example.auth.KDUser;
import com.example.auth.configuration.ApplicationConstant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Component
public class JwtUtils {

    private final JwtParser jwtParser;
    private final Date      nowDate;

    public JwtUtils()
    {
        JwtParser parser = Jwts.parserBuilder().setSigningKey(ApplicationConstant.SECRET_KEY).build();
        this.jwtParser = parser;
        this.nowDate = new Date();
    }

    public String createJwt(KDUser u, long expPeriod)
    {
        Claims claims = Jwts.claims().setSubject(u.getUser_id())
                .setIssuedAt(this.nowDate)
                .setExpiration(new Date(this.nowDate.getTime() + expPeriod))
                .setIssuer(ApplicationConstant.SERVER_HOST);

        claims.put("roles", u.getRoles().toString());

        return Jwts.builder().setClaims(claims).compact();
    }

    public Set<String> getRolesFromJwt(String jwt)
    {
        Jwt<Header<?>, Claims> jjwt = jwtParser.parse(jwt);

        Claims claims = jjwt.getBody();

        return StringUtils.commaDelimitedListToSet((String) claims.get("roles"));
    }

    public boolean introspectJwt(String jwt)
    {
        Jwt<Header<?>, Claims> jjwt = jwtParser.parse(jwt);
        Date expTime = jjwt.getBody().getExpiration();

        return !expTime.before(this.nowDate);
    }
}
