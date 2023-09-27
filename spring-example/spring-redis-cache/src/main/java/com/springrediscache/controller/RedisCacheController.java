package com.springrediscache.controller;

import com.springrediscache.service.RedisCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisCacheController {
    private final RedisCacheService redisCacheService;
    private int counter = 0;

    public RedisCacheController(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if(counter==5){
            redisCacheService.clearCache();
            counter=0;
        }
        counter++;
        return redisCacheService.longRunningMethod();
    }
}
