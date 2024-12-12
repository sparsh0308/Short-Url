package com.shortUrl.service;

import com.shortUrl.config.RedisService;
import com.shortUrl.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        return "localhost:8080/"+urlChars;
    }

    @Override
    public ResponseEntity<Void> getOriginalUrl(String shortUrl) {
        String originalUrl = redisService.get(shortUrl);
        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header("Location", originalUrl)
                .build();
    }
}
