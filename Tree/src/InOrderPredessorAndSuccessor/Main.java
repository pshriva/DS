package InOrderPredessorAndSuccessor;

public class Main {

	public static void main(String[] args) {
		BST bst = new BST();
		bst.root = new Node(70);
		bst.root.left = new Node(30);
		bst.root.left.left = new Node(20);
		bst.root.left.left.left = new Node(10);
		bst.root.left.left.right = new Node(25);
		bst.root.left.right = new Node(50);
		bst.root.left.right.left = new Node(45);
		bst.root.left.right.right = new Node(60);
		bst.root.right = new Node(100);
		bst.root.right.left = new Node(80);
		bst.root.right.left.left = new Node(75);
		bst.root.right.left.right = new Node(90);
		bst.root.right.right = new Node(120);
		bst.root.right.right.left = new Node(110);
		bst.root.right.right.right = new Node(150);
//		bst.getInorderTraversal();
		//returning 0 in case there is no predecessor
		Node n = bst.root.right.right.right;
		Node predecessor = bst.getPredecessor(n);
		if(predecessor != null) {System.out.println("Node " + n.val + " Predecessor " + predecessor.val);}
		else {System.out.println("No predecessor found");}
	}

}
