package ClosestBinarySearchTreeValueII;

import java.util.*;
//LL
// Reference : https://www.jiuzhang.com/solution/closest-binary-search-tree-value-ii/
public class solution {

	public static void main(String[] args) {
		Node root = new Node(9);
		root.left = new Node(4);
		root.right = new Node(17);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(7);
		root.right.right = new Node(22);
		root.right.right.left = new Node(20);
		double target = 6;
		int k = 5;
		List<Integer> result = closestKValues(root, target, k);
		System.out.println(result);
	}

	
//	Space - O(logn), TC = O(k + logn)~ O(logn)
	private static List<Integer> closestKValues(Node root, double target, int k) {
		List<Integer> result = new ArrayList<>();
		if(k == 0 || root == null){return result;}
		Stack<Node> pred = new Stack<>();
		getPredecessorNodes(root, pred, target);
		Stack<Node> successor = new Stack<>();
		successor.addAll(pred);
		if(target < pred.peek().val){
			getPredNodes(pred);
		}else{
			getSuccNodes(successor);
		}
		
		for(int i = 0 ; i < k; i++){
			if(pred.isEmpty() || (!successor.isEmpty() && (target - pred.peek().val) > (successor.peek().val - target))){
				result.add(successor.peek().val);
				getSuccNodes(successor);
			}else{
				result.add(pred.peek().val);
				getPredNodes(pred);
			}
		}
		return result;
	}

	private static void getSuccNodes(Stack<Node> successor) {
		Node node = successor.peek();
		if(node.right == null){
			node = successor.pop();
			while(!successor.isEmpty() && successor.peek().right == node){
				node = successor.pop();
			}
			return;
		}
		node = node.right;
		while(node != null){
			successor.push(node);
			node = node.left;
		}
	}

	private static void getPredNodes(Stack<Node> pred) {
		Node node = pred.peek();
		if(node.left == null){
			node = pred.pop();
			while(!pred.isEmpty() && pred.peek().left == node){
				node = pred.pop();
			}
			return;
		}
		node = node.left;
		while(node != null){
			pred.push(node);
			node = node.right;
		}
	}

	private static void getPredecessorNodes(Node root, Stack<Node> stack, double target) {
		while(root != null){
			stack.push(root);
			root = target < root.val ? root.left : root.right;
		}
	}

	
//	SC - O(n), TC - O(n)
//	Find the inorder traversal, keep a left and right pointer to the node nearest to target,
//	Keep calculating distance from left and right, and accordingly keep doing left--, right++
//	public List<Integer> closestKValues(TreeNode root, double target, int k) {
//        List<Integer> values = new ArrayList<>();
//        
//        traverse(root, values);
//        
//        int i = 0, n = values.size();
//        for (; i < n; i++) {
//            if (values.get(i) >= target) {
//                break;
//            }
//        }
//        
//        if (i >= n) {
//            return values.subList(n - k, n);
//        }
//        
//        int left = i - 1, right = i;
//        List<Integer> result = new ArrayList<>();
//        for (i = 0; i < k; i++) {
//            if (left >= 0 && (right >= n || target - values.get(left) < values.get(right) - target)) {
//                result.add(values.get(left));
//                left--;
//            } else {
//                result.add(values.get(right));
//                right++;
//            }
//        }
//        
//        return result;
//    }
//    
//    private void traverse(TreeNode root, List<Integer> values) {
//        if (root == null) {
//            return;
//        }
//        
//        traverse(root.left, values);
//        values.add(root.val);
//        traverse(root.right, values);
//    }
//	
//	

}
