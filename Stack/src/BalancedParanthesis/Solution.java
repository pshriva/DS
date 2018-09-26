package BalancedParanthesis;

import java.util.Stack;

public class Solution {
	public static void main(String args[]) {
		String par = "((()()()))";
		System.out.println(isBalancedParanthesis(par));
		par = "[(]){}{[()()]()}";
		System.out.println(isBalanced(par));
	}

	// using stack
	private static boolean isBalanced(String par) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<par.length(); i++) {
			char ch = par.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			if(stack.isEmpty() || (ch == ')' && stack.peek() != '(') || 
					(ch == ']' && stack.peek() != '[') ||
					(ch == '}' && stack.peek() != '{')) {
				return false;
			}
			stack.pop();
		}
		return stack.isEmpty();
	}
	
	

	private static boolean isBalancedParanthesis(String par) {
		int count = 0;
		for(int i = 0; i<par.length(); i++) {
			char ch = par.charAt(i);
			count = (ch == '(') ? count+1 : count-1;
			if(count < 0) {return false;}
		}
		return true;
	}
}
