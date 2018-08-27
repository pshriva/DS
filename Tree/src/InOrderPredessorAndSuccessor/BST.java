package InOrderPredessorAndSuccessor;

public class BST {
	Node root;

	public void getInorderTraversal() {
		getInorderTraversal(root);
	}

	private void getInorderTraversal(Node root) {
		if(root == null) {return;}
		getInorderTraversal(root.left);
		System.out.println(root.val);
		getInorderTraversal(root.right);
	}

	public Node getPredecessor(Node n) {
		if(n == null) {return null;}
		if(n.left != null) {
			Node temp = n.left;
			while(temp.right != null) {
				temp = temp.right;
			}
			return temp;
		}
		Node ancestor = null;
		Node parent = root;
		Node current = n;
		while(current.val != parent.val) {
			if(current.val < parent.val) {
				parent = parent.left;
			}else {
				ancestor = parent;
				parent = parent.right;
			}
		}
		return ancestor;
	}
}
