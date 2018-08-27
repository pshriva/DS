package EvaluationOfPostfixPrefixExpressions;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		String exp = "231*+9-";
		int sum = getPostfixEvaluation(exp);
		System.out.println(sum);
		exp = "+9*26";
		sum = getPrefixEvaluation(exp);
		System.out.println(sum);
	}

	private static int getPrefixEvaluation(String exp) {
		if(exp == null || exp.length() == 0) {return Integer.MIN_VALUE;}
		Stack<Integer> stack = new Stack<>();
		for(int i = exp.length()-1; i>= 0; i--) {
			char ch = exp.charAt(i);
			if(Character.isDigit(ch)) {stack.push(ch - '0');}
			else {
				int n1 = stack.pop();
				int n2 = stack.pop();
				switch(ch) {
					case '+':
						stack.push(n1+n2);
						break;
					case '-':
						stack.push(n1-n2);
						break;
					case '*':
						stack.push(n1*n2);
						break;
					case '/':
						stack.push(n1/n2);
				}
			}
		}
		return stack.pop();
	}

	private static int getPostfixEvaluation(String exp) {
		if(exp == null || exp.length() == 0) {return Integer.MIN_VALUE;}
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i<exp.length(); i++) {
			char ch = exp.charAt(i);
			if(Character.isDigit(ch)) {stack.push(ch - '0');}
			else {
				int n1 = stack.pop();
				int n2 = stack.pop();
				switch(ch) {
					case '+' :
						stack.push(n2+n1);
						break;
					case '-':
						stack.push(n2 - n1);
						break;
					case '*':
						stack.push(n2*n1);
						break;
					case '/':
						stack.push(n2/n1);
				}
			}
		}
		return stack.pop();
	}

}
