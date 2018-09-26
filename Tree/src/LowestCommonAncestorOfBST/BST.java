package LowestCommonAncestorOfBST;
//LCA
public class BST {
	Node root;

	public Node getLowestCommonAncestor(Node child1, Node child2) {
		Node curr = root;
		while(curr != null){
			if(child1.val < curr.val && child2.val < curr.val){
				curr = curr.left;
			}else if(child1.val > curr.val && child2.val > curr.val){
				curr = curr.right;
			}else{
				return curr;
			}
		}
		
		return null;
	}
}
