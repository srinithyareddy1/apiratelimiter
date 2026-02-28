package com.example.apiratelimiter.controller;

import com.example.apiratelimiter.service.RateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private RateLimiterService rateLimiterService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam String user) {

        if(rateLimiterService.allowRequest(user)) {
            return "Hello " + user + " 👋";
        } else {
            return "Rate limit exceeded ❌";
        }
    }
}