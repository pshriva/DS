package InfixToPostfix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//infix to prefix - Reverse the infix, calculate the postfix, reverse the postfix again
public class Solution {
	public static void main(String args[]) {
		String infix = "(A+B)*(C+D)";
		String postfix = getPostfix(infix);
		System.out.println(postfix);
	}

	private static String getPostfix(String infix) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		for(int i = 0 ; i<infix.length(); i++) {
			char ch = infix.charAt(i);
			if(ch == '(') {
				stack.push(ch);
			}
			else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result = result + stack.pop();
				}
				stack.pop();
			}else if(isOperator(ch)) {
				while(!stack.isEmpty() && stack.peek() != '(' && hasHigherPrecedence(stack.peek(), ch)) {
					result = result +stack.pop();
				}
				stack.push(ch);
			}else{
				result = result + ch;
			}
		}
		while(!stack.isEmpty()) {result = result + stack.pop();}
		return result;
	}

	private static boolean hasHigherPrecedence(Character peek, char ch) {
		Map<Character, Integer> precedence = new HashMap<>();
		precedence.put('+', 0);
		precedence.put('-', 0);
		precedence.put('*', 1);
		precedence.put('/', 1);
		precedence.put('%', 1);
		return (precedence.get(peek) > precedence.get(ch));
	}

	private static boolean isOperator(char ch) {
		// TODO Auto-generated method stub
		return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%');
	}
	
	
}
