package LN;

import java.util.*;
import java.util.Map.Entry;

public class Solution {
	public static void main(String [] args){
		int[] count = {2,1,1,2,1};
		getGroups(count);
	}

//	private static void getGroups(int[] count) {
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		for(int i = 0; i< count.length; i++){
//			int group = count[i];
//			if(map.containsKey(group)){
//				if(map.get(group).size() == group){
//					System.out.println(map.get(group));
//					map.put(group, new ArrayList<>(Arrays.asList(i)));
//				}else{
//					map.get(group).add(i);
//				}
//			}else{
//				map.put(group, new ArrayList<>(Arrays.asList(i)));
//			}
//		}
//		for(Entry<Integer, List<Integer>> key : map.entrySet()){
//			System.out.println(key.getValue());
//		}
//	}
	private static void getGroups(int[] count) {
		Map<Integer, List<List<Integer>>> map = new LinkedHashMap<>();
		for(int i = 0; i< count.length; i++){
			int group = count[i];
			if(map.containsKey(group)){
				List<List<Integer>> memList = map.get(group);
				List<Integer> lastList = memList.get(memList.size() - 1);
				if(lastList.size() == group){
					memList.add(new ArrayList<Integer>(Arrays.asList(i)));
				}else{
					lastList.add(i);
				}
			}else{
				map.put(group, new ArrayList<>());
				map.get(group).add(new ArrayList<>(Arrays.asList(i)));
			}
		}
		for(Integer group : map.keySet()){
			for(List<Integer> members : map.get(group)){
				if(members.size() == group){
					for(int i = 0; i< members.size(); i++){
						System.out.print(members.get(i) + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
