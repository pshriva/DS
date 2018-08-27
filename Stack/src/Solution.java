import java.util.Stack;

public class Solution {
	public static void main(String args[]) {
		String boolExpr = "&( t, |(t, &(f,f,t)) )";
		System.out.println(calculateBoolean(boolExpr));
	}

	private static boolean calculateBoolean(String boolExpr) {
		if(boolExpr == null) {return false;}
		if(boolExpr.length() == 0) {return true;}
		if(boolExpr.length() == 1) {return boolExpr.equals("t") ? true : false;}
		boolExpr = boolExpr.replaceAll(" ", "").replaceAll(",", "");
		Stack<Character> stack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		int i = 0;
		char result = 'f';
		while(i < boolExpr.length()){
			while(i < boolExpr.length() && boolExpr.charAt(i) != ')' && !isOperator(boolExpr.charAt(i))) {
				stack.push(boolExpr.charAt(i));
				i++;
			}
			if(isOperator(boolExpr.charAt(i))) {
				operatorStack.push(boolExpr.charAt(i));
			}
			if(boolExpr.charAt(i) == ')') {
			if(operatorStack.peek() != '!') {
				result = getBinaryResult(stack, operatorStack.pop());
			}else {
				result = getUnaryresult(operatorStack.pop(), stack);
			}
			operatorStack.pop();
			i++;
			}
		}
		return result == 'f' ? false : true;
	}

	private static char getUnaryresult(char operator, Stack<Character> stack) {
		char result = 'f';
		while(stack.peek() != '(') {
			result = stack.pop() == 'f' ? 't' : 'f';
		}
		stack.pop();
		return result;
	}

	private static boolean isOperator(char ch) {
		// TODO Auto-generated method stub
		return ch == '!' || ch == '&' || ch == '|';
	}

	private static char getBinaryResult(Stack<Character> stack, char operator) {
		char one = stack.pop();
		while(stack.peek() != '(') {
			char two = stack.pop();
			one = getBinaryResult(one, two, operator);
		}
		stack.pop();
		return one;
	}

	private static char getBinaryResult(char one, char two, char operator) {
		if(operator == '&') {
			return one == two ? one : 'f';
		}
		return one == two ? one : 't';
	}
}
