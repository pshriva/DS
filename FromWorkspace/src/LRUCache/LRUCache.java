package LRUCache;

import java.util.List;
import java.util.*;
//Lame but LCA
//public class LRUCache {
//	
//	class Data{
//		int key;
//		int value;
//		public Data(int key, int value){
//			this.key = key;
//			this.value = value;
//		}
//	}
//	List<Data> list;
//	int capacity;
//	public LRUCache(int capacity){
//		this.capacity = capacity;
//		list = new ArrayList<>();
//	}
//	public int get(int key) {
//		int value = -1;
//		Data current = null;
//		for(Data d : list){
//			if(d.key == key){
//				current = d;
//				break;
//			}
//		}
//		if(current != null){
//			value = current.value;
//			list.remove(current);
//			list.add(0, current);
//		}
//		return value;
//	}
//	public void put(int key, int value) {
//		Data newData = null;
//		for(Data d : list){
//			if(d.key == key){
//				newData = d;
//			}
//		}
//		if(newData != null){
//			list.remove(newData);
//			list.add(0, new Data(key, value));
//			return;
//		}
//		if(capacity == 0){
//			list.remove(list.size() - 1);
//			capacity++;
//		}
//		list.add(0, new Data(key, value));
//		capacity--;
//	}
//}
// Apparantly same as above in terms of space, but just saving the time, since we do not need to iterate the list ever
public class LRUCache {
	List<Integer> index;
	Map<Integer, Integer> map;
	int capacity;
	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<>();
		index = new ArrayList<>();
	}
	
	public int get(int key){
		int value = -1;
		if(map.containsKey(key)){
			value = map.get(key);
			index.remove((Integer)(key));
			index.add(0, key);
		}
		return value;
	}
	
	public void put(int key, int value){
		if(map.containsKey(key)){
			index.remove((Integer)(key));
			index.add(0, key);
		}
		else if(capacity == 0){
			int lastKey = index.remove(index.size() - 1);
			map.remove(lastKey);
			index.add(0, key);
		}else{
			index.add(0, key);
			capacity--;
		}
		map.put(key, value);
	}
}
