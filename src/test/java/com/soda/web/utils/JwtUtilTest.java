package com.soda.web.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JwtUtilTest {

    JwtUtil jwtUtil;

    @BeforeEach
    public void setUp(){
        jwtUtil = new JwtUtil();
    }

    @Test
    void createToken() {
        String userId = "test";
        String password = "123456";

        String token = jwtUtil.createToken(userId, password);

        assertThat(token).isEqualTo(".");
    }

    @Test
    void getClaims(){
        String token = "eyJhbGciOiJIUzI1NiJ9."
                + "eyJ1c2VySWQiOiJ0ZXN0IiwicGFzc3dvcmQiOiIxMjM0NTYifQ."
                + "ljtQPkX37-3p8Pks50LQDXDXviDp5-GTz9snHeNECaM";
        Claims claims = jwtUtil.getClaims(token);

        assertThat(claims.get("userId")).isEqualTo("test");
        assertThat(claims.get("password")).isEqualTo("123456");
    }

}