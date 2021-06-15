package com.flipkart.NewsFeed.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reactions {
    private Integer upvotes;
    private Integer downvotes;

    public Reactions(){
        this.downvotes = 0;
        this.upvotes = 0;
    }

    public Reactions(Integer upvotes, Integer downvotes) {
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public void upvote(){
        this.upvotes +=1;
    }
    public void downvote(){
        this.downvotes +=1;
    }
}
