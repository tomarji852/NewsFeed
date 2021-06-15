package com.flipkart.NewsFeed.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
public class Comment {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private Integer id;
    @Setter private Reactions reactions;
    private String userName;
    @Setter private String commentDescription;
    private LocalDateTime time;
    @Setter private List<Comment> innerComments;

    public Comment(Reactions reactions, String userName, String commentDescription) {
        this.id = counter.incrementAndGet();;
        this.reactions = reactions;
        this.userName = userName;
        this.commentDescription = commentDescription;
        this.time = LocalDateTime.now();
    }
}
