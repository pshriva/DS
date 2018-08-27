package EvaluationOfTFExpression;

import java.util.Stack;
/*Given a string representing a boolean expression where "t" means true and "f" means false and
 * there are 3 operators. [&, |, !]
 * &() operator takes 2 or more operands (logical and)
 * !() operator takes a single operand (logical not)
 * |() takes 2 operands (logical or)
 * evaluate the final result of the expression
 */
public class Solution {
	public static void main(String[] args) {
//		String expr = "!(&(t,!(!(t))))";
		String expr = "&(f, |(t, &(f, t)))";
		boolean result = evaluateExpression(expr);
		System.out.println(result);
	}

	private static boolean evaluateExpression(String expr) {
		if(expr == null) {return false;}
		if(expr.length() == 0) {return true;}
		if(expr.length() == 1) {return expr.equals("t") ? true : false;}
		expr = expr.replaceAll(" ","").replaceAll(",","");
		Stack<Character> stack = new Stack<>(); //
		Stack<Character> operatorStack = new Stack<>(); // 
		char result = 'f';
		for(int i = 0; i <expr.length(); i++) {
			char ch = expr.charAt(i);
			if(isOperator(ch)) {
				operatorStack.push(ch);
			}else if(ch != ')') {
				stack.push(ch);
			}else {
				result = getResult(stack, operatorStack.pop());
				stack.push(result);
			}
		}
		return stack.pop() == 't' ? true : false;
	}

	private static char getResult(Stack<Character> stack, char operator) {
		char result = 'f';
		if(operator == '!') {
			while(stack.peek() != '(') {
				result = stack.pop() == 't' ? 'f' : 't';
			}
		}else {
			result = stack.pop();
			if(operator == '&') {
				while(stack.peek() != '(') {
					result = result == stack.pop() ? result : 'f';
				}
			}else {
				while(stack.peek() != '(') {
					result = result == stack.pop() ? result : 't';
				}
			}
		}
		stack.pop();
		return result;
	}

	private static boolean isOperator(char ch) {
		return ch == '&' || ch == '|' || ch == '!';
	}
}
