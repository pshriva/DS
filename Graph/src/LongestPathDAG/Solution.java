package LongestPathDAG;

public class Solution {

	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.createEdge(8, 0);
		g.createEdge(0, 2);
		g.createEdge(0, 3);
		g.createEdge(0, 4);
		g.createEdge(1, 2);
		g.createEdge(1, 7);
		g.createEdge(2, 5);
		g.createEdge(3, 5);
		g.createEdge(3, 7);
		g.createEdge(4, 7);
		g.createEdge(5, 6);
		g.createEdge(6, 7);
		g.display();
		System.out.println(g.getLongestPath());
	}

}
