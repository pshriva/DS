package CloneGraph;

import java.util.*;

public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int label){
		this.label = label;
		neighbors = new ArrayList<>();
	}
}
