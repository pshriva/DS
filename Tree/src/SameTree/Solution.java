package SameTree;
//LCA
public class Solution {
	public static void main(String []args){
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		boolean isSame = isSame(root1, root2);
		System.out.println(isSame);
	}

	private static boolean isSame(Node root1, Node root2) {
		if(root1 == null && root2 == null){return true;}
		if(root1 == null || root2 == null || root1.val != root2.val){
			System.out.println("Returning false");
			return false;
		}
		System.out.println(root1.right.val + " " + root2.right.val );
		return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
	}
}
