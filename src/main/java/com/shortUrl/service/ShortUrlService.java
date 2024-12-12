package com.shortUrl.service;

import org.springframework.http.ResponseEntity;

public interface ShortUrlService {

    String generateShortUrl(String url);
    ResponseEntity<Void> getOriginalUrl(String shortUrl);
}
