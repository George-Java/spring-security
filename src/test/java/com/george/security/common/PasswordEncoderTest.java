package com.george.security.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootTest
public class PasswordEncoderTest {
    @Autowired
    //注入SecurityConfig中配置的bean->BCryptPasswordEncoder
    private PasswordEncoder passwordEncoder;

    @Test
    public void test() {
        String password = "Zhc20050105@";

        String encryptPassword = passwordEncoder.encode(password);
        log.info("加密后的密码为:{}", encryptPassword);

        boolean result = passwordEncoder.matches(password, encryptPassword);
        log.info("密码比对结果:{}", result);
    }
}
