package ConstructStringFromBinaryTree;
//LCA
public class Solution {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		String result = createString(root);
	}

	private static String createString(Node root) {
		if(root == null){return "";}
		StringBuilder sb = new StringBuilder();
		createString(root, sb);
		System.out.println(sb.toString());
		return sb.toString();
	}

	private static void createString(Node node, StringBuilder sb) {
		if(node == null){return;}
		sb.append(node.val);
		if(!(node.left == null && node.right == null)){sb.append("(");}
		if(node.left != null){
			createString(node.left, sb);
		}
		if(!(node.left == null && node.right == null)){sb.append(")");}
		if(node.right != null){
			sb.append("(");
			createString(node.right, sb);
			sb.append(")");
		}
	}

}
