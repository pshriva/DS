import java.util.*;

public class Solution {
	static Map<String, HashSet<String>> map = new HashMap<>();
	public static void main(String[] args) {
		add("id1", "id2");
		remove("id1");
	}

	private static void remove(String id) {
		if(!map.containsKey(id)){return;}
		HashSet<String> sets = map.get(id);
		for(String set :sets){
			HashSet<String> s = map.get(set);
			s.remove(id);
			map.put(set, s);
		}
		map.remove(id);
	}

	private static void add(String id1, String id2) {
		if(id1.equals(id2)){return;}
		if(!map.containsKey(id1)){map.put(id1, new HashSet<>());}
		if(!map.containsKey(id2)){map.put(id2, new HashSet<>());}
		HashSet<String> nodes = map.get(id1);
		for(String node : nodes){
			if(!map.containsKey(node)){map.put(node, new HashSet<>());}
			HashSet<String> s = map.get(node);
			s.add(id2);
			map.put(node, s);
		}
		HashSet<String> s = map.get(id1);
		s.add(id2);
		map.put(id1, s);
		s = map.get(id2);
		s.add(id1);
		map.put(id2, s);
	}

}
