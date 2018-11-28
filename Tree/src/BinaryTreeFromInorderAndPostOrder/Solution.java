package BinaryTreeFromInorderAndPostOrder;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] inOrder = {9,3,15,20,7};
		int[] postOrder = {9,15,7,20,3};
		TreeNode root = createTree(inOrder, postOrder);
		System.out.println(root.right.right.val);
	}

	private static TreeNode createTree(int[] inOrder, int[] postOrder) {
		return createTree(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
	}

	private static TreeNode createTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart < 0 || postStart > postEnd){return null;}
		TreeNode root = new TreeNode(postOrder[postEnd]);
		int rootIndex = 0;
		for(int i = inStart; i<=inEnd ; i++){
			if(inOrder[i] == root.val){
				rootIndex = i;
				break;
			}
		}
		root.left = createTree(inOrder, postOrder, inStart, rootIndex - 1, postStart, (postStart + rootIndex - (inStart + 1)));
		root.right = createTree(inOrder, postOrder, rootIndex+1, inEnd, (postStart + rootIndex - inStart), postEnd - 1);
		return root;
	}

}
