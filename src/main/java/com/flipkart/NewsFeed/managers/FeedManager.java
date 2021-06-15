package com.flipkart.NewsFeed.managers;

import com.flipkart.NewsFeed.exceptions.NoUserFoundException;
import com.flipkart.NewsFeed.models.Comment;
import com.flipkart.NewsFeed.models.Post;
import com.flipkart.NewsFeed.models.Reactions;
import com.flipkart.NewsFeed.models.User;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedManager {
    Map<Integer, Post> posts;
    Map<User, Map<Integer, Post>> userPosts;

    public FeedManager(){
        this.posts = new HashMap<>();
        this.userPosts = new HashMap<>();
    }

    public Post createPost(User user, String postDescription){
        Reactions reactions = new Reactions();
        Post post  = new Post(reactions, user.getUserName(), postDescription);
        posts.put(post.getId(), post);

        Map<Integer, Post> postByUser;
        if(!userPosts.containsKey(user)){
            postByUser = new HashMap<>();
            postByUser.put(post.getId(), post);
            userPosts.put(user, postByUser);
        }
        else{
            postByUser = userPosts.get(user);
            postByUser.put(post.getId(), post);
            userPosts.put(user, postByUser);
        }

        return post;
    }

    public synchronized void upvote(User user, Post post){
        Reactions reactions = post.getReactions();
        reactions.upvote();
        post.setReactions(reactions);
        posts.put(post.getId(), post);
        userPosts.put(user, posts);
    }

    public synchronized void downvote(User user, Post post){
        Reactions reactions = post.getReactions();
        reactions.downvote();
        post.setReactions(reactions);
        posts.put(post.getId(), post);
        userPosts.put(user, posts);
    }

    public List<Post> getAllPosts(User user){
        List<Post> posts;
        if(!userPosts.containsKey(user)){
            posts = new ArrayList<>();
        }
        else{
            posts =new ArrayList<Post>(userPosts.get(user).values());
        }
        return posts;
    }

    public Comment createComment(User user, String commentDiscrtion, Post post){
        List<Comment> comments = post.getComments();
        Comment comment = new Comment(new Reactions(), user.getUserName(), commentDiscrtion);
        comments.add(comment);
        post.setComments(comments);
        posts.put(post.getId(), post);
        userPosts.put(user, posts);
        return comment;
    }
}
