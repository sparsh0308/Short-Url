package com.shortUrl.controller;

import com.shortUrl.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/short-url")
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @PostMapping(value = "/generate/")
    public String generateShortUrl(@RequestParam String url) {
        return shortUrlService.generateShortUrl(url);
    }

    @GetMapping(value = "/get-original-url/")
    public String getOriginalUrl(@RequestParam String shortUrl) {
        return shortUrlService.getOriginalUrl(shortUrl);
    }
}
