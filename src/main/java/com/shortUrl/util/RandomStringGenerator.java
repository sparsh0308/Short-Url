package com.shortUrl.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomStringGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 8;
    private static final int CHARACTERS_LENGTH = CHARACTERS.length(); // Pre-calculate length

    public String generateRandomString() {
        // Create a char array to store the result
        char[] result = new char[STRING_LENGTH];

        // Generate random characters for each position
        for (int i = 0; i < STRING_LENGTH; i++) {
            result[i] = CHARACTERS.charAt(ThreadLocalRandom.current().nextInt(CHARACTERS_LENGTH));
        }

        return new String(result);
    }
}
