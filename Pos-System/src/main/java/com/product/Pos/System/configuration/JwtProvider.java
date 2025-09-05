package com.product.Pos.System.configuration;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JwtProvider {
    static Securitykey key= Keys.hmacShaKeyFor(JwtConstant.JWT_SECRET.getBytes());

  public String generateToken(Authentication authentication)
    {
        Collection<?extends GrantedAuthority> authorities =
    }}
