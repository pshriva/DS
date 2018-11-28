package LFUCache;

import java.util.*;

public class Solution {
	public static void main(String args[]){
		int capacity = 2;
		LFUCache cache = new LFUCache(capacity);
		cache.put(1,1);
		System.out.println(cache.get(1));
	}
}
