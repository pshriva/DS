package DesignTwitter;

import java.util.*;
//Time limit exceeded only
public class Twitter {
	Map<Integer, ArrayList<Integer>> isFollowedBy;
	Map<Integer, ArrayList<Integer>> tweets;
	Map<Integer, LinkedHashMap<Integer, Integer>> userFeed;
	public Twitter(){
		isFollowedBy = new HashMap<>();
		tweets = new HashMap<>();
		userFeed = new HashMap<>();
	}
	public void postTweet(int userId, int tweetId) {
//		If this user has tweeted before, add new tweet to his list, or create new list for him
		if(tweets.containsKey(userId)){tweets.get(userId).add(tweetId);}
		else{tweets.put(userId, new ArrayList<>(Arrays.asList(tweetId)));}
		
//		Add the new tweet to users own userFeed
		if(!userFeed.containsKey(userId)){userFeed.put(userId, new LinkedHashMap());}
		userFeed.get(userId).put(tweetId, userId);

//		If this user is followed by others, add this tweet to his follower's lists
		if(isFollowedBy.containsKey(userId)){
			for(Integer follower : isFollowedBy.get(userId)){
//				if there is no userfeed for the followers, add the userfeed for them
				if(!userFeed.containsKey(follower)){userFeed.put(follower, new LinkedHashMap<>());}
//				If there are already max tweets, remove the 1st tweet
				if(userFeed.get(follower).size() >= 10){
					int key = userFeed.get(follower).keySet().iterator().next();
					userFeed.get(follower).remove(key);
				}
				userFeed.get(follower).put(tweetId, userId);
			}
		}
	}
	public List<Integer> getNewsFeed(int userId) {
		if(!userFeed.containsKey(userId)){userFeed.put(userId, new LinkedHashMap());}
		List<Integer> feed = new ArrayList<>();
		for(Integer key : userFeed.get(userId).keySet()){
			feed.add(0, key);
		}
		return feed;
	}
	public void follow(int followerId, int followeeId) {
		if(isFollowedBy.containsKey(followeeId)){isFollowedBy.get(followeeId).add(followerId);}
		else{
			isFollowedBy.put(followeeId, new ArrayList<>(Arrays.asList(followerId)));
		}
	}
	public void unfollow(int followerId, int followeeId) {
//		Remove the relation from the followers map
		if(!isFollowedBy.containsKey(followeeId)){return;}
		isFollowedBy.get(followeeId).remove(Integer.valueOf(followerId));
		
//		Remove the tweets of the followee from the follower userFeed
		Set<Integer> tweets = new HashSet<>();
		for(Integer tweet : userFeed.get(followerId).keySet()){
			tweets.add(tweet);
		}
		for(Integer tweet : tweets){
			if(userFeed.get(followerId).get(tweet) ==followeeId ){
				userFeed.get(followerId).remove(tweet);
			}
		}
	}
	public void getStatus() {
		System.out.println("1. Following status ");
		for(int key : isFollowedBy.keySet()){
			System.out.println(key + " is followed by -> " + isFollowedBy.get(key));
		}
		System.out.println("2. Tweets status");
		for(int key : tweets.keySet()){
			System.out.println(key + " tweeted -> " + tweets.get(key));
		}
		System.out.println("3. UserFeed status");
		for(int key : userFeed.keySet()){
			System.out.print("For user " + key + " -> ");
			for(int k : userFeed.get(key).keySet()){
				System.out.print(", ("+k + "," + userFeed.get(key).get(k) + ") ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
