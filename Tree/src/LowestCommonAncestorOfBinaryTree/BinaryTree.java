package LowestCommonAncestorOfBinaryTree;


public class BinaryTree {
	Node root;

	//LCA but way too slow
//	public Node getLowestCommonAncestor(Node child1, Node child2) {
//		if(root == null || child1 == null || child2 == null){return null;}
//		Node temp = root;
//		while(temp != null){
//			if(contains(temp.left, child1) && contains(temp.left, child2)){temp = temp.left;}
//			else if(contains(temp.right, child1) && contains(temp.right, child2)){temp = temp.right;}
//			else {return temp;}
//			
//		}
//		return null;
//	}
//
//	private boolean contains(Node root, Node child) {
//		if(root == null){return false;}
//		if(root == child){return true;}
//		return contains(root.left, child) || contains(root.right, child);
//	}
//	LCA
	public Node getLowestAncestor(Node root, Node child1, Node child2){
		if(root == null || child1 == null || child2 == null){return null;}
		if(root == child1 || root == child2){return root;}
		Node leftNode = getLowestAncestor(root.left, child1, child2);
		Node rightNode = getLowestAncestor(root.right, child1, child2);
		if(leftNode != null && rightNode != null){return root;}
		return leftNode == null?rightNode : leftNode;
	}
}
