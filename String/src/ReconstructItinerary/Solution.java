package ReconstructItinerary;

import java.util.*;
//https://leetcode.com/problems/reconstruct-itinerary/discuss/78799/Very-Straightforward-DFS-Solution-with-Detailed-Explanations
// LCA
public class Solution {
	private int numTickets = 0;
	public static void main(String[] args) {
//		String[][] tickets = {{"JFK","SFO"},
//						   {"JFK","ATL"},
//						   {"SFO","ATL"},
//						   {"ATL","JFK"},
//						   {"ATL","SFO"}};
		String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
		List<String> result = getItinirary(tickets);
		System.out.println(result);
	}

	private static List<String> getItinirary(String[][] tickets) {
		LinkedList<String> result = new LinkedList<>();
		if(tickets == null || tickets.length == 0){return result;}
		Map<String, List<String>> map = new HashMap<>();
		int[] ticketsLeft = new int[]{tickets.length};
		for(String[] ticket : tickets){
			String from = ticket[0];
			String to = ticket[1];
			if(!map.containsKey(from)){
				map.put(from, new ArrayList<>());
			}
			map.get(from).add(to);
		}
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			Collections.sort(entry.getValue());
		}
		String from = "JFK";
		result.add(from);
		dfs(ticketsLeft, map, result, from);
		return result;
	}

	private static void dfs(int[] ticketsLeft, Map<String, List<String>> map, LinkedList<String> result, String from) {
		if(!map.containsKey(from)){return;}
		List<String> temp = map.get(from);
		for(int i = 0; i < temp.size(); i++){
			String curr = temp.remove(i); 
			ticketsLeft[0]--;
			result.add(curr);
			dfs(ticketsLeft, map, result, curr);
			if(ticketsLeft[0] == 0){return;}
			ticketsLeft[0]++;
			temp.add(i, curr);
			result.removeLast();
		}
	}

}
