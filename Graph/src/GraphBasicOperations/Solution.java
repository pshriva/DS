package GraphBasicOperations;
// BFS, DFS, Time complexity is O(V+E)
public class Solution {
	public static void main(String args[]) {
		Graph g = new Graph(6);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
//		System.out.println("Displaying all elements:");
//		g.display();
//		System.out.println("Breadth First Traversal:");
//		g.getBFS();
//		System.out.println("Depth first traversal:");
		g.getDFS();
//		Graph g = new Graph(11);
//		g.addEdge(0,2);
//		g.addEdge(0,3);
//		g.addEdge(0,4);
//		g.addEdge(2,5);
//		g.addEdge(1,2);
//		g.addEdge(1,7);
//		g.addEdge(3,5);
//		g.addEdge(3,7);
//		g.addEdge(4,7);
//		g.addEdge(5,6);
//		g.addEdge(6,7);
//		g.addEdge(0,1);
//		g.addEdge(1,2);
//		g.addEdge(9,2);
//		g.addEdge(1,6);
//		g.addEdge(6,8);
//		g.addEdge(2,4);
//		g.addEdge(2,3);
//		g.addEdge(6,7);
//		g.addEdge(4,5);
//		g.addEdge(5,10);
//		g.display();
		
	}
}
