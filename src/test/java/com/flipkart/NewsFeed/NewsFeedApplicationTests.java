package com.flipkart.NewsFeed;

import com.flipkart.NewsFeed.managers.CustomerManager;
import com.flipkart.NewsFeed.managers.FeedManager;
import com.flipkart.NewsFeed.models.Post;
import com.flipkart.NewsFeed.models.User;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class NewsFeedApplicationTests {
	CustomerManager customerManager;
	FeedManager feedManager;

	@BeforeEach
	void setup(){
		customerManager = new CustomerManager();
		feedManager = new FeedManager();
	}


	@Test
	void runnerTest() {
		customerManager.signUpCustomer("Sunil Tomar");//id 1
		customerManager.signUpCustomer("aman");//id 2
		customerManager.signUpCustomer("Deepak");//id 3

		User sunil = customerManager.loginCustomer(1, "Sunil Tomar");
		feedManager.createPost(sunil, "I am sunil tomar");
		customerManager.followUser(sunil.getUserId(), 1);
		customerManager.followUser(sunil.getUserId(), 2);

		User aman = customerManager.loginCustomer(2, "aman");
		List<Post> sunilPost = feedManager.getAllPosts(sunil);
		feedManager.createComment(aman, "Wow you are sunil", sunilPost.get(0));
		List<Post> sunilPost2 = feedManager.getAllPosts(sunil);

	}

}
