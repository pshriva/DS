package AddOneRowToTree;

import java.util.LinkedList;
import java.util.Queue;
//LCA
public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		int v = 1;
		int d = 3;
		TreeNode newRoot = addValueAtDepth(root, v, d);
		printTree(root);
	}

	private static void printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode n = queue.poll();
			System.out.println(n.val);
			if(n.left != null){queue.add(n.left);}
			if(n.right != null){queue.add(n.right);}
		}
		
	}

	private static TreeNode addValueAtDepth(TreeNode root, int v, int d) {
		if(d == 1){
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
		if(d == 1){
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty() && d >0){
            d--;
            int size = queue.size();
            for(int i = 0; i<size;i++){
                TreeNode n = queue.poll();
                if(d == 1){
                    TreeNode left = n.left;
                    TreeNode right = n.right;
                    n.left = new TreeNode(v);
                    n.right = new TreeNode(v);
                    n.left.left = left;
                    n.right.right = right;
                }else{
                    if(n.left != null){queue.add(n.left);}
                    if(n.right != null){queue.add(n.right);}
                }
            }
        }
        return root;
	}

}
