package kr.kko.kakaoassignapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KakaoAssignApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaoAssignApiApplication.class, args);
    }

}