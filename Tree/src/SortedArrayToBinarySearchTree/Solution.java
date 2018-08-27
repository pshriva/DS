package SortedArrayToBinarySearchTree;
//LCA
public class Solution {
	public static void main(String args[]) {
		int[] arr = {-10,-3,0,5,9};
		BST bst = new BST();
		bst.root = getBST(arr);
		
	}

	private static Node getBST(int[] arr) {
		return getBinarySearchTree(arr, 0, arr.length - 1);
	}

	private static Node getBinarySearchTree(int[] arr, int left, int right) {
		Node root = null;
		if(left <= right){
			int mid = left + (right-left)/2;
			root = new Node(arr[mid]);
			root.left = getBinarySearchTree(arr, left, mid-1);
			root.right = getBinarySearchTree(arr, mid+1, right);
		}
		return root;
	}

	
}
