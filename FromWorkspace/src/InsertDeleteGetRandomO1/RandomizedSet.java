package InsertDeleteGetRandomO1;

import java.util.*;

public class RandomizedSet {
	Map<Integer, Integer> map;
	List<Integer> list;
	public RandomizedSet(){
		map = new HashMap<>();
		list = new ArrayList<>();
	}
	public boolean insert(int val) {
		if(map.containsKey(val)){return false;}
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	public boolean remove(int val) {
		if(!map.containsKey(val)){return false;}
		int listIndex = map.get(val);
		if(listIndex < list.size() - 1){
			int lastListElement = list.get(list.size() - 1);
			map.put(lastListElement, listIndex);
			list.set(listIndex, lastListElement);
		}
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	public int getRandom() {
		return list.get(new java.util.Random().nextInt(list.size()));
	}
	
}
