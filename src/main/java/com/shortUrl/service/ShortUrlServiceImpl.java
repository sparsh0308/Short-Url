package com.shortUrl.service;

import com.shortUrl.config.RedisService;
import com.shortUrl.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ShortUrlServiceImpl implements ShortUrlService{

    @Autowired
    private RandomStringGenerator randomStringGenerator;

    @Autowired
    private RedisService redisService;

    @Override
    public String generateShortUrl(String url) {
        String urlChars = randomStringGenerator.generateRandomString();
        if (redisService.get(url) != null) {
            urlChars = randomStringGenerator.generateRandomString();
        }
        redisService.save(urlChars, url);
        return "Saved";
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        String originalUrl = redisService.get(shortUrl);
        if (originalUrl == null) {
            return "Original URL not found for the provided short URL.";
        }
        return originalUrl;
    }
}
