package treeOperations;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	Node root;
	public void insert(int value) {
		root = insert(root, value);
	}
	
	//recursive
	private Node insert(Node root, int value) {
		if(root == null) {
			root = new Node(value);
		}else if(value <= root.value) {
			root.left = insert(root.left, value);
		}else {
			root.right = insert(root.right, value);
		}
		return root;
	}
	
	//Iterative
//	public void getBFS() {
//		if(root == null) {
//			System.out.println("Tree is empty");
//			return;
//		}
//		Queue<Node> queue = new LinkedList<>();
//		queue.add(root);
//		while(!queue.isEmpty()) {
//			Node n = queue.remove();
//			System.out.println(n.value);
//			if(n.left != null) {queue.add(n.left);}
//			if(n.right != null) {queue.add(n.right);}
//		}
//	}
	
	//Recursive
	public void getBFS() {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		getBFS(queue);
	}
	private void getBFS(Queue<Node> queue) {
		if(root == null || queue.isEmpty()) {return;}
		Node n = queue.remove();
		System.out.println(n.value);
		if(n.left != null) {queue.add(n.left);}
		if(n.right != null) {queue.add(n.right);}
		getBFS(queue);
	}
	
	
	//Iterative
//	public void getDFS() {
//		if(root == null) {
//			System.out.println("Tree is empty");
//			return;
//		}
//		Stack<Node> stack = new Stack<>();
//		stack.push(root);
//		while(!stack.isEmpty()) {
//			Node n = stack.pop();
//			System.out.println(n.value);
//			if(n.right != null) {stack.push(n.right);}
//			if(n.left != null) {stack.push(n.left);}
//		}
//	}

	//Recursive
	public void getDFS() {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		getDFS(root);
	}
	public void getDFS(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.value);
		getDFS(root.left);
		getDFS(root.right);
	}
	
	//Recursive search
//	public boolean search(int element) {
//		return search(root, element);
//	}
//	//Recursive search internal call
//	private boolean search(Node root, int element) {
//		if(root == null) {return false;}
//		if(element == root.value) {return true;}
//		if(element < root.value) {return search(root.left, element);}
//		else {return search(root.right, element);}
//	}
	
	//Iterative search
	public boolean search(int element) {
		if(root == null) {return false;}
		Node temp = root;
		while(temp != null) {
			if(element == temp.value) {return true;}
			if(element < temp.value) {temp = temp.left;}
			else {temp = temp.right;}
		}
		return false;
	}

	public int getHeight() {
		// height = 0 means only root is available, height = -1 means tree is null
		return getHeight(root);
	}

	private int getHeight(Node root) {
		if(root == null) {return -1;}
		return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
	}

	public void getZigZagTraversal() {
		// TODO Auto-generated method stub
		if(root == null) {System.out.println("Tree is empty");}
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		Node n = null;
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				n = s1.pop();
				System.out.println(n.value);
				if(n.left != null) {s2.push(n.left);}
				if(n.right != null) {s2.push(n.right);}
			}
			while(!s2.isEmpty()) {
				n = s2.pop();
				System.out.println(n.value);
				if(n.right != null) {s1.push(n.right);}
				if(n.left != null) {s1.push(n.left);}
			}
		}
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root);
	}

	private boolean isBinarySearchTree(Node root) {
		if(root == null) {return true;}
		if((root.left != null && root.left.value > root.value) ||
		   (root.right != null && root.right.value <= root.value)) {
			return false;
		}
		return (isBinarySearchTree(root.left) && isBinarySearchTree(root.right));
	}

	public void removeElement(int i) {
		// TODO Auto-generated method stub
		root = removeElement(root, i);
	}

	private Node removeElement(Node root, int i) {
		// TODO Auto-generated method stub
		if(root == null) {return root;}
		if(i< root.value) {root.left = removeElement(root.left, i);}
		else if(i > root.value) {root.right = removeElement(root.right, i);}
		else {
			if(root.left == null && root.right == null) {
				root = null;
			}else if(root.left == null) {root = root.right;}
			else if(root.right == null) {root = root.left;}
			else {
				Node minimum = getMinimum(root.right);
				root.value = minimum.value;
				root.right = removeElement(root.right, minimum.value);
			}
		}
		return null;
	}

	private Node getMinimum(Node root) {
		while(root.left != null && root.right != null) {
			root = root.left;
		}
		return root;
	}

	public void getInordertraversal() {
		// TODO Auto-generated method stub
		getInordertraversal(root);
	}

	private void getInordertraversal(Node root) {
		if(root == null) {return;}
		getInordertraversal(root.left);
		System.out.println(root.value);
		getInordertraversal(root.right);
	}

	public void getPreorderTraversal() {
		getPreorderTraversal(root);
	}

	private void getPreorderTraversal(Node root) {
		if(root == null) {return;}
		System.out.println(root.value);
		getPreorderTraversal(root.left);
		getPreorderTraversal(root.right);
	}

	public void getPostorderTraversal() {
		getPostorderTraversal(root);
	}

	private void getPostorderTraversal(Node root) {
		if(root == null) {return;}
		getPostorderTraversal(root.left);
		getPostorderTraversal(root.right);
		System.out.println(root.value);
	}
	
	public Node getInorderSuccessor(Node node) {
		if(root == null) {System.out.println("Tree is empty"); return null;}
		if(node == null) {System.out.println("Node is null"); return null;}
		if(node.right != null) {
			return getSmallestNodeInRightSubtree(node.right);
		}
		Node ancestor = null;
		Node parent = root;
		while(parent != node) {
			if(node.value == parent.value) {return parent;}
			if(node.value > parent.value) {
				parent = parent.right;
			}else if(node.value < parent.value) {
				ancestor = parent;
				parent = parent.left;
			}
		}
		return ancestor;
	}

	private Node getSmallestNodeInRightSubtree(Node node) {
		while(node != null && node.left != null) {node = node.left;}
		return node;
	}
	
}
