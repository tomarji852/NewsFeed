package com.flipkart.NewsFeed.managers;

import com.flipkart.NewsFeed.exceptions.NoUserFoundException;
import com.flipkart.NewsFeed.models.Post;
import com.flipkart.NewsFeed.models.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerManager {
    Map<Integer, User> users;
    Map<User, List<User>> userFollowMap; // this user is following list<user> users

    public  CustomerManager(){
        this.userFollowMap = new HashMap<>();
        this.users = new HashMap<>();
    }

    public User signUpCustomer(String name){
        User user = new User(name);
        users.put(user.getUserId(), user);
        userFollowMap.put(user, new ArrayList<>());

        return user;
    }

    public User loginCustomer(Integer userId,  String name){
        if(!users.containsKey(userId)){
            System.out.println("No user found for this userid" + userId);
            throw new NoUserFoundException();
        }

        return users.get(userId);
    }

    public void followUser(Integer userId, Integer followerId){ // follower is following user
        User user = users.get(followerId);
        if(!userFollowMap.containsKey(user)){
            List<User> followings = new ArrayList<>();
            followings.add(user);
            userFollowMap.put(user, followings);
        }
        else{ ;
            List<User> followings = userFollowMap.get(user);
            followings.add(user);
            userFollowMap.put(user, followings);
        }
    }

    public List<User> getFollowingsForUser(Integer userId){
        if(!users.containsKey(userId)){
            System.out.println("No user found for this userid" + userId);
            throw new NoUserFoundException();
        }
        User user = users.get(userId);
        return userFollowMap.get(user);
    }
}
