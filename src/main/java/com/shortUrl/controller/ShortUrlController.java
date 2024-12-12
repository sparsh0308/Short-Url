package com.shortUrl.controller;

import com.shortUrl.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @PostMapping(value = "/generate-short-url")
    public String generateShortUrl(@RequestParam String url) {
        return shortUrlService.generateShortUrl(url);
    }

    @GetMapping(value = "/{shortUrl}")
    public ResponseEntity<Void> getOriginalUrl(@PathVariable String shortUrl) {
        return shortUrlService.getOriginalUrl(shortUrl);
    }
}
