package DesignTwitter;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Twitter t = new Twitter();
//		t.postTweet(1, 5);
//		System.out.println(t.getNewsFeed(1));
//		t.follow(1,2);
//		t.postTweet(2, 6);
//		t.postTweet(2, 7);
//		System.out.println(t.getNewsFeed(1));
//		t.unfollow(1,2);
//		System.out.println(t.getNewsFeed(1));
		
		
		t.postTweet(6, 422);
//		t.getStatus();
		t.follow(2, 8);
//		t.getStatus();
		t.postTweet(3, 887);
//		t.getStatus();
		t.postTweet(1,614);
//		t.getStatus();
		t.postTweet(4,127);
//		t.getStatus();
		t.unfollow(1, 4);
//		t.getStatus();
		System.out.println(t.getNewsFeed(1));
		t.postTweet(4,300);
//		t.getStatus();
		t.postTweet(8,497);
//		t.getStatus();
		t.postTweet(6,710);
		t.postTweet(3,77);
		t.follow(8, 8);
		t.postTweet(6,300);
		t.postTweet(3,291);
		t.postTweet(2,665);
		t.postTweet(8,818);
		t.postTweet(7,542);
		t.postTweet(5,634);
		t.follow(1, 6);
		t.postTweet(9,565);
		t.postTweet(6,136);
		t.postTweet(7,342);
		t.postTweet(10,591);
		System.out.println(t.getNewsFeed(3));
		t.postTweet(9, 953);
	}

}
