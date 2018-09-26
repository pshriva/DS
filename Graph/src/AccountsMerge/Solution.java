package AccountsMerge;

import java.util.*;
//LCA
public class Solution {
	public static void main(String args[]){
		List<List<String>> accounts = new ArrayList<>(Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
																	Arrays.asList("John", "johnnybravo@mail.com"),
																	Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
																	Arrays.asList("Mary", "mary@mail.com")));
		List<List<String>> result = mergeAccounts(accounts);
		System.out.println(result);
	}

	private static List<List<String>> mergeAccounts(List<List<String>> accounts) {
		Map<String, String> names = new HashMap<>();
		Map<String, Set<String>> graph = new HashMap<>();
		for(List<String> account : accounts){
			String name = account.get(0);
			for(int i = 1; i< account.size(); i++){
				names.put(account.get(i), name);
				String email = account.get(i);
				if(!graph.containsKey(email)){
					graph.put(email, new HashSet<>());
				}
				if(i == 1)continue;
				graph.get(email).add(account.get(i-1));
				graph.get(account.get(i-1)).add(email);
			}
		}
		
		Set<String> visited = new HashSet<>();
		List<List<String>> result = new ArrayList<>();
		for(String email : names.keySet()){
			List<String> list = new ArrayList<>();
			if(visited.add(email)){
				addNodes(graph, email, visited, list);
				Collections.sort(list);
				list.add(0, names.get(email));
				result.add(list);
			}
		}
		return result;
	}

	private static void addNodes(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
		list.add(email);
		for(String e : graph.get(email)){
			if(visited.add(e)){
				addNodes(graph, e, visited, list);
			}
		}
		
	}
}
