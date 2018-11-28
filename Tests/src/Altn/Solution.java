package Altn;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		String parenthesis = "[ABC[23]][89]";
		long index = 1;
		long result = solution(parenthesis, index);
		System.out.println(result);
	}

	private static long solution(String parenthesis, long index) {
		if(parenthesis.charAt((int)index) != '('){return -1;}
		Stack<Integer> stack = new Stack<>();
		for(int i = (int)index; i<parenthesis.length(); i++){
			if(parenthesis.charAt(i) == '('){stack.push(i);}
			else if(parenthesis.charAt(i) == ')'){stack.pop();}
			if(stack.isEmpty()){return (long)i;}
			
		}
		return -1;
	}

}
