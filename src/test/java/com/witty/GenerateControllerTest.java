package com.witty;

import com.witty.entity.User;
import com.witty.utils.TokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

        String token = TokenUtils.getToken(user);
        System.out.println(token);


        Map<String, String> stringStringMap = TokenUtils.parseToken(token);
        stringStringMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

}
