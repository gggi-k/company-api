package kr.company.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ValueSource(strings = {"jd123", "jdd123", "jdm123"})
    @ParameterizedTest
    void test(String originPassword) {
        System.out.println(passwordEncoder.encode(originPassword));
    }

}