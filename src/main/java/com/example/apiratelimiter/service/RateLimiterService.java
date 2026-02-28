package com.example.apiratelimiter.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class RateLimiterService {

    private Map<String, Integer> requestCounts = new HashMap<>();
    private final int LIMIT = 5;

    public boolean allowRequest(String user) {
        requestCounts.put(user, requestCounts.getOrDefault(user, 0) + 1);
        return requestCounts.get(user) <= LIMIT;
    }
}