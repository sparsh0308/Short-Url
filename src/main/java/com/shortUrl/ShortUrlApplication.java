package com.shortUrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShortUrlApplication {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SpringApplication.run(ShortUrlApplication.class, args);
    }
}