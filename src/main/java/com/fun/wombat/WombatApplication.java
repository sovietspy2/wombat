package com.fun.wombat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class WombatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WombatApplication.class, args);
    }

}
