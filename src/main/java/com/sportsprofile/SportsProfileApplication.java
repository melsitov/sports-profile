package com.sportsprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.sportsprofile", exclude = {SecurityAutoConfiguration.class})
public class SportsProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsProfileApplication.class, args);
    }
}