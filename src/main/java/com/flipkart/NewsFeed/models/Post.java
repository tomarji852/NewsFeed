package com.flipkart.NewsFeed.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
public class Post {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private Integer id;
    @Setter private Reactions reactions;
    private String userName;
    @Setter private String postDescription;
    private LocalDateTime time;
    @Setter private List<Comment> comments;

    public Post(Reactions reactions, String userName, String postDescription) {
        this.id = counter.incrementAndGet();
        this.reactions = reactions;
        this.userName = userName;
        this.postDescription = postDescription;
        this.time = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }
}
