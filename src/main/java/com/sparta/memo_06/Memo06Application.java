package com.sparta.memo_06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Memo06Application {

    public static void main(String[] args) {
        SpringApplication.run(Memo06Application.class, args);
    }

}
