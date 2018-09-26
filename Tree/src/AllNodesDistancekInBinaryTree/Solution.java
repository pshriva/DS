package AllNodesDistancekInBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
//Both solutions, LCA, Better - without creating graph
public class Solution {

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(6);
//		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(3);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(4);
//		root.left.left.right.right = new TreeNode(5);
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(3);
		List<Integer> result = getNodesAtDistanceK(root, root.left, 3);
		System.out.println(result);
	}
//Approach 1, LCA, create a gragh, make the target node as root and do a level order traversal until k levels,
//	and add all elements of this level k to the returning ressulting list
//	private static List<Integer> getNodesAtDistanceK(TreeNode root, TreeNode target, int k) {
//		List<Integer> result = new ArrayList<>();
//		Map<TreeNode, List<TreeNode>> map = new HashMap<>();
//		createGraph(map, null, root);
//		Queue<TreeNode> queue = new LinkedList<>();
//		Set<TreeNode> visited = new HashSet<>();
//		queue.add(target);
//		visited.add(target);
//		while(!queue.isEmpty()){
//			int size = queue.size();
//			if(k == 0){
//				for(int i = 0; i< size; i++){result.add(queue.poll().val);}
//				return result;
//			}
//			for(int i = 0; i< size; i++){
//				TreeNode n = queue.poll();
//				for(TreeNode curr : map.get(n)){
//					if(visited.add(curr)){
//						queue.add(curr);
//					}
//				}
//			}
//			k--;
//		}
//		return result;
//	}
//	
//	private static void createGraph(Map<TreeNode, List<TreeNode>> map, TreeNode parent, TreeNode child) {
//		if(child == null){return;}
//		if(!map.containsKey(child)){
//			map.put(child, new ArrayList<>());
//			if(parent != null){
//				map.get(parent).add(child);
//				map.get(child).add(parent);
//			}
//		}
//		createGraph(map, child, child.left);
//		createGraph(map, child, child.right);
//	}

	private static List<Integer> getNodesAtDistanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<>();
		if(k == 0){
            result.add(target.val);
            return result;
        }
//		Traverse k levels down the tree to add all the child nodes at the distance k
//		target node added twice so as to reuse the function after findnig paths below
		getAllChildrenAtDistanceK(result, target, target, k, null);
//		System.out.println(result);
//		to get resulting nodes that are in the sibling tree to the target node, or at the parent of the target,
//		start from the root and put all the nodes that come in the path to the target node
//		and later we can traverse to these nodes and find out the K distant nodes
		Map<TreeNode, Integer> map = new HashMap<>();
		buildPath(map, root, target, 1);
		int mapSize = map.size();
		for(TreeNode node : map.keySet()){
			int label = map.get(node);
//			any node beyond the distance k should not be considered
			if(label < (mapSize - k + 1)){continue;}
//			if the node itself is at the distance k, then its value should be added and its children need not be considered
			if(label == (mapSize - k + 1)){result.add(node.val);continue;}
//			if this node is at a distance 3 already and we had to find nodes at a distance of 5 from target node
//			then we can only go (5-3 = 2) levels down this node
			getAllChildrenAtDistanceK(result, node, target, label - (mapSize - k + 1), map);
		}
		return result;
	}

	private static boolean buildPath(Map<TreeNode, Integer> map, TreeNode node, TreeNode target, int distance) {
		if(node == null){return false;}
		if(node ==  target){return true;}
		map.put(node, distance);
		boolean left = buildPath(map, node.left, target, distance+1);
		boolean right = buildPath(map, node.right, target, distance+1);
		if(!left && !right){
			map.remove(node);
			return false;
		}
		return true;
	}

	private static void getAllChildrenAtDistanceK(List<Integer> result, TreeNode node, TreeNode target, int k, Map<TreeNode, Integer>map) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			int size = queue.size();
			if(k == 0){
				for(int i = 0; i < size; i++){
					result.add(queue.poll().val);
				}
				return;
			}
			for(int i = 0; i< size; i++){
				TreeNode n = queue.poll();
				if(n.left != null && n.left != target && (map == null || !map.containsKey(n.left))){queue.add(n.left);}
				if(n.right != null && n.right != target && (map == null || !map.containsKey(n.right))){queue.add(n.right);}
			}
			k--;
		}
	}
	
	

}
