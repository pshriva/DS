package SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {

	//BFS
//	public String serialize(TreeNode root) {
//		StringBuilder sb = new StringBuilder();
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.add(root);
//		while(!queue.isEmpty()){
//			TreeNode n = queue.poll();
//			if(n != null){
//				sb.append(n.val).append(" ");
//				queue.add(n.left);
//				queue.add(n.right);
//			}else{
//				sb.append("null ");
//			}
//		}
//		return sb.toString();
//	}
//	
//	public TreeNode deserialize(String s){
//		String[] nodes = s.split(" ");
//		Queue<TreeNode> queue = new LinkedList<>();
//		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//		queue.add(root);
//		for(int i = 1; i< nodes.length; i++){
//			TreeNode parent = queue.poll();
//			if(!nodes[i].equals("null")){
//				parent.left = new TreeNode(Integer.parseInt(nodes[i]));
//				queue.add(parent.left);
//			}
//			if(!nodes[++i].equals("null")){
//				parent.right = new TreeNode(Integer.parseInt(nodes[i]));
//				queue.add(parent.right);
//			}
//		}
//		return root;
//	}
//DFS
	
	public void InorderTraversal(TreeNode t) {
		if(t == null){return;}
		InorderTraversal(t.left);
		System.out.println(t.val);
		InorderTraversal(t.right);
		
	}

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
	    serialize(root, sb);
	    return sb.toString();
	}
	//DFS

	private void serialize(TreeNode root, StringBuilder sb) {
		if(root == null){
			sb.append("null ");
		}else{
			sb.append(root.val).append(" ");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	public TreeNode deserialize(String s) {
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(s.split(" ")));
		return createTree(queue);
	}

	private TreeNode createTree(Queue<String> queue) {
		String s = queue.poll();
		if(s.equals("null")){return null;}
		TreeNode root = new TreeNode(Integer.parseInt(s));
		root.left = createTree(queue);
		root.right = createTree(queue);
		return root;
	}
	
	

}
