package com.george.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Instant;
import java.util.Map;

public class JwtUtil {
    private static final String secret = "#@token%$3240908!^&";

    public static String getToken(Map<String, String> claims) {
        Instant instant = Instant.now();
        instant = instant.plusSeconds(60 * 60 * 24L);
        JWTCreator.Builder builder = JWT.create();
        claims.forEach((key, value) -> {
            builder.withClaim(key, value);
        });

        return builder.withExpiresAt(instant)
                .sign(Algorithm.HMAC256(secret));
    }

    public static DecodedJWT verifyJwtToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();

        return jwtVerifier.verify(token);
    }
}
