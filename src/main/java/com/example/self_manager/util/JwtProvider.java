package com.example.self_manager.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.self_manager.config.LineChannelConfig;
import com.example.self_manager.domain.Jwt;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.example.self_manager.constant.SecurityConstant.TOKEN_CAN_NOT_VERIFY;
import static com.example.self_manager.constant.SecurityConstant.VALID_SUCCESSFUL_MSG;
import static com.example.self_manager.constant.SecurityConstant.VALID_UNSUCCESSFUL_EXPIRED_MSG;
import static com.example.self_manager.constant.SecurityConstant.VALID_UNSUCCESSFUL_UN_VALID_MSG;

@Service
public class JwtProvider {
    private Algorithm algorithm;
    private JWTVerifier verifier;

    public JwtProvider() {
        this.algorithm = Algorithm.HMAC512(LineChannelConfig.CHANNEL_ID_SECRET.getBytes());
        this.verifier = JWT.require(algorithm).build();
    }

    public String getToken(String sub, long expiresTime, String issue) {
        String token = JWT.create()
                .withSubject(sub)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiresTime))
                .withIssuer(issue)
                .sign(algorithm);
        return token;
    }

    public Jwt validToken (String token) {
        Jwt jwt = new Jwt();
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            jwt.setAccount(decodedJWT.getSubject());
            jwt.setIssue(decodedJWT.getIssuer());
            jwt.setMessage(VALID_SUCCESSFUL_MSG);
            jwt.setExpire(true);
        } catch (TokenExpiredException tokenExpiredException) {
            // the token is Expired
            jwt.setMessage(VALID_UNSUCCESSFUL_EXPIRED_MSG);
            jwt.setExceptionMsg(tokenExpiredException.getMessage());
            jwt.setExpire(false);
        } catch (JWTDecodeException jwtDecodeException) {
            // the token is un-valid
            jwt.setMessage(VALID_UNSUCCESSFUL_UN_VALID_MSG);
            jwt.setExceptionMsg(jwtDecodeException.getMessage());
            jwt.setExpire(false);
        } catch (Exception e) {
            jwt.setMessage(TOKEN_CAN_NOT_VERIFY);
            jwt.setExceptionMsg(e.getMessage());
            jwt.setExpire(false);
        }
        return jwt;
    }

    public static String getRandomInts() {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        String rtn = "";
        for (int i = 0; i < 5; i++) {
            int random = randomDataGenerator.nextInt(0, 9);
            rtn = rtn + random;
        }
        return rtn;
    }
}
