package AddAndSearchWordDataStructure;

public class Node {
	boolean isWord;
	Node[] child;
	public Node(){
		child = new Node[26];
	}
}
