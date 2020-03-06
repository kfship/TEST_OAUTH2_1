package com.oauthtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncodingTest {


    @Test
    public void encodingTest() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("111111111"));

        String encryptedStr = "$2a$10$CoHIqL0e35H21rdmmD/Rue2oJcSjN2FOJy5hvthy/CdZ2hzkR/1F6";

        System.out.println(bCryptPasswordEncoder.matches("bar", encryptedStr));

    }


}
