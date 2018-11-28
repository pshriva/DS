package VerticalOrderTraversal;

import java.util.List;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
//	used only for another way solution
	int min;
	int max;
	public TreeNode(int val){
		this.val = val;
	}
	public List<List<Integer>> getVerticalOrder(TreeNode root) {
		findMinMax(root, 0);
		System.out.println("Min " + min + " Max " + max);
		for(int i = min; i<= max; i++){
// For every i, it traversess almost the whole tree, so not a very good approach
			printVerticalElements(root, min, 0);
			System.out.println();
		}
		
		return null;
	}
	private void printVerticalElements(TreeNode node, int serialLevel, int curr_level) {
		if(node == null){return;}
		if(serialLevel == curr_level){
			System.out.print(node.val + " ");
		}
		printVerticalElements(node.left, serialLevel, curr_level-1);
		printVerticalElements(node.right, serialLevel, curr_level+1);
	}
	private void findMinMax(TreeNode node, int level) {
		if(node == null){return;}
		if(level < min){min = level;}
		if(level > max){max = level;}
		findMinMax(node.left, level-1);
		findMinMax(node.right , level+1);
	}
	
	
}
