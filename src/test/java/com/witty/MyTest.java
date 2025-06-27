package com.witty;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
public class MyTest {

    @Test
    public void test() {
           isNaN(false);
    }

    public void isNaN(boolean flag) {
        if (flag)
            System.out.println("真的");
        else
            System.out.println("假的");
    }

    @Test
    public void baseTest() throws UnsupportedEncodingException {
        String name = "黄琳";

        String base64Name = Base64.getEncoder().encodeToString(name.getBytes(StandardCharsets.UTF_8));


        System.out.println("base64: " + base64Name);


        byte[] decode = Base64.getDecoder().decode(base64Name);
        System.out.println("decode: " + new String(decode, StandardCharsets.UTF_8));
    }
}
