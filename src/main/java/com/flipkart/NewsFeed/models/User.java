package com.flipkart.NewsFeed.models;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class User {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private Integer userId;
    private String userName;

    public User( String userName) {
        this.userId = counter.incrementAndGet();
        this.userName = userName;
    }
}
