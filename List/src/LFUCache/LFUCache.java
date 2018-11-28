package LFUCache;

import java.util.*;
//LCA
public class LFUCache {
	int capacity;
	Map<Integer, Integer> values;
	Map<Integer, Integer> counts;
	Map<Integer, LinkedHashSet<Integer>> list;
	int minCount;
	public LFUCache(int capacity) {
		this.capacity = capacity;
		values = new HashMap<>();
		counts = new HashMap<>();
		list = new HashMap<>();
		list.put(1, new LinkedHashSet<>());
		minCount = -1;
	}
	public int get(int key){
		if(!values.containsKey(key)){return -1;}
		int count = counts.get(key);
		counts.put(key, count+1);
		list.get(count).remove(key);
		if(count == minCount && list.get(count).size() == 0){minCount++;}
		if(!list.containsKey(count+1)){list.put(count+1, new LinkedHashSet<Integer>());}
		list.get(count+1).add(key);
		return values.get(key);
	}
	public void put(int key, int value) {
		if(capacity <= 0){return;}
		if(values.containsKey(key)){
			values.put(key, value);
			get(key);
			return;
		}
		if(capacity <= values.size()){
			int keyToRemove = list.get(minCount).iterator().next();
			counts.remove(keyToRemove);
			values.remove(keyToRemove);
			list.get(minCount).remove(keyToRemove);
		}
		values.put(key, value);
		counts.put(key, 1);
		minCount = 1;
		list.get(1).add(key);
	}
	
}
