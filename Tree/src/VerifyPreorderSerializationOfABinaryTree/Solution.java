package VerifyPreorderSerializationOfABinaryTree;

import java.util.Stack;
//LCA
public class Solution {
	public static void main(String[] args){
		String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		boolean isPreorder = isValidSerialization(preOrder);
		System.out.println(isPreorder);
	}
//LCA	
	private static boolean isValidSerialization(String preOrder) {
		int degree = 1;
		String[] order = preOrder.split(",");
		for(String curr : order){
			degree--;
			if(degree < 0){return false;}
			if(!curr.equals("#")){degree = degree + 2;}
		}
		return degree == 0;
	}
//LCA
//	private static boolean isValidSerialization(String preOrder) {
//		Stack<String> stack = new Stack<>();
//		String[] pre = preOrder.split(",");
//		for(String s : pre){
//			while(s.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
//				stack.pop();
//				if(stack.isEmpty()){return false;}
//				stack.pop();
//			}
//			stack.push(s);
//		}
//		return stack.size() == 1 && stack.peek().equals("#");
//	}
}
