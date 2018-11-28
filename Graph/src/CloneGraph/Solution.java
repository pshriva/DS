package CloneGraph;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
		UndirectedGraphNode zero = new UndirectedGraphNode(0);
		UndirectedGraphNode one = new UndirectedGraphNode(1);
		UndirectedGraphNode two = new UndirectedGraphNode(2);
		zero.neighbors.add(one);
		zero.neighbors.add(two);
		one.neighbors.add(two);
		two.neighbors.add(two);
		UndirectedGraphNode cloned = cloneGraph(zero);
		
//		Printing the cloned graph
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		queue.add(cloned);
		while(!queue.isEmpty()){
			UndirectedGraphNode curr = queue.poll();
			if(visited.add(curr.label)){
				System.out.println("Node " + curr.label);
				for(UndirectedGraphNode node : curr.neighbors){
					System.out.println(node.label);
					queue.add(node);
				}
			}
		}
	}
	
	private static UndirectedGraphNode cloneGraph(UndirectedGraphNode zero) {
		if(zero == null){return null;}
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(zero);
		map.put(zero.label, new UndirectedGraphNode(zero.label));
		while(!queue.isEmpty()){
			UndirectedGraphNode curr = queue.poll();
			UndirectedGraphNode temp = map.get(curr.label);
//			if(visited.add(curr.label)){  // can ignore using the set if it is a connected graph
			if(map.get(curr.label).neighbors.size() == 0){
				for(UndirectedGraphNode node : curr.neighbors){
					UndirectedGraphNode inList;
					if(!map.containsKey(node.label)){
						inList = new UndirectedGraphNode(node.label);
						map.put(node.label, inList);
					}else{
						inList = map.get(node.label);
					}
					temp.neighbors.add(inList);
					queue.add(node);
				}
			}
		}
		return map.get(zero.label);
	}

}
