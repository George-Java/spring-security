package com.george.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.george.security.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Slf4j
public class JwtTest {
    @Test
    public void testCreateJwtToken() {
        String token = JwtUtil.getToken(Map.of("name", "张三", "userId", "123456"));
        log.info("token:{}", token);
    }

    @Test
    public void testVerifyJwtToken() {
        DecodedJWT verify = JwtUtil.verifyJwtToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoi5byg5LiJIiwidXNlcklkIjoiMTIzNDU2IiwiZXhwIjoxNzkwNzc3OTIyfQ.ucRL6GzBkF950Vr1x1A9wk5Sg-pGHvBDnhX9eYnXt68");

        String userId = verify.getClaim("userId").asString();

        log.info("userId:{}", userId);
    }
}
