package com.witty;

import com.witty.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Map;

@SpringBootTest
public class GenerateControllerTest {

    @Test
    public void testToken() {
        User user = new User();

        user.setId(1);
        user.setUsername("test");
        user.setName("test");
        user.setPassword("123456");
        user.setEmail("test@test.com");
        user.setAvatar("https://xxxx.fsd.png");
        user.setCreateTime(LocalDateTime.now());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String token = bCryptPasswordEncoder.encode(user.getPassword());
        System.out.println(token);

    }

}
