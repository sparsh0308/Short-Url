package com.shortUrl.service;

public interface ShortUrlService {

    String generateShortUrl(String url);
    String getOriginalUrl(String shortUrl);
}
