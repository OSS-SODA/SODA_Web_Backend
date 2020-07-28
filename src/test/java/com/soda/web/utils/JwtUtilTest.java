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
}