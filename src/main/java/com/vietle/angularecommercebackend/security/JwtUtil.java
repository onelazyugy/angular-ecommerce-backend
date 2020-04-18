package com.vietle.angularecommercebackend.security;

import com.vietle.angularecommercebackend.domain.Role;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JwtUtil {
    private JwtUtil () {}

    public static String createToken(String email, List<Role> roles, long validityInMilliseconds, String secretKey) throws EcommerceException {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        if(StringUtils.isEmpty(token)) {
            throw new EcommerceException("unable to create access token", 500);
        }
        return token;
    }
}
