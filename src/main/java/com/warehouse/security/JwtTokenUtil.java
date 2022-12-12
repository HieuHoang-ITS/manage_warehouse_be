package com.warehouse.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Configuration
public class JwtTokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${warehouse.app.jwtSecret}")
    private String jwtSecret;

    @Value("${warehouse.app.jwtExpirationMs}")
    private int jwtExpiraionMs;

//    private LoggedOutJwtTokenCache loggedOutJwtTokenCache;
//    public void setLoggedOutJwtTokenCache(LoggedOutJwtTokenCache lgogedOutJwtTokenCache) {
//        this.loggedOutJwtTokenCache = lgogedOutJwtTokenCache;
//    }

    public String generateJwtToken(String userName) {
        Claims claims = Jwts.claims().setSubject(userName);
        Date currentTime = new Date();
        return Jwts.builder().setClaims(claims).setIssuedAt(currentTime)
                .setExpiration(new Date(currentTime.getTime() + jwtExpiraionMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public Date getExtAt(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getExpiration();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            validateTokenIsNotForALoggedOutDevice(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    private void validateTokenIsNotForALoggedOutDevice(String token) {
        

    }
}
