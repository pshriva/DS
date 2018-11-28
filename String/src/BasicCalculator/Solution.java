package BasicCalculator;

import java.util.*;
// LCA both
public class Solution {
	public static void main(String[] args) {
//		String s = "(1+(4+5+2)-3)+(6+8)";
//		String s = " 2-1 + 2 ";
		String s = "2-(5-6)";
//		String s = "2-(5-6)";
//		String s = "(-4+3 - (+ 2 - 4) - 3)-2 +1";
		int result = calculate(s);
		System.out.println(result);
	}

// Iterative
//	private static int calculate(String s) {
//		if(s == null || s.length() == 0){return 0;}
//		Stack<Integer> stack = new Stack<>();
//		int result = 0;
//		int sign = 1;
//		for(int i = 0; i< s.length(); i++){
//			char ch = s.charAt(i);
//			if(Character.isDigit(ch)){
//				int num = ch - '0';
//				while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
//					num = num*10 + (s.charAt(i+1) - '0');
//					i++;
//				}
//				result = result + sign*num;
//			}else if(ch == '+'){sign = 1;}
//			else if(ch == '-'){sign = -1;}
//			else if(ch == '('){
//				stack.push(result);
//				stack.push(sign);
//				result = 0;
//				sign = 1;
//			}else if(ch == ')'){
//				result = result * stack.pop() + stack.pop();
//			}
//		}
//		return result;
//	}
	
	
//	Recursive
	private static int calculate(String s) {
		if(s == null || s.length() == 0){return 0;}
		int[] res = calculate(s, 0);
		return res[0];
	}

private static int[] calculate(String s, int i) {
	int result = 0;
	int curr = 0;
	int sign = 1;
	for(int j = i; j< s.length(); j++){
		char ch = s.charAt(j);
		if(Character.isDigit(ch)){
			curr = curr *10 + ch - '0';
		}else if(ch == '+' || ch == '-'){
			result += curr*sign;
			curr = 0;
			sign = ch == '+' ? 1 : -1;
		}else if(ch == '('){
			int[] res = calculate(s, j+1);
			result += res[0]*sign;
			j = res[1];
		}else if(ch == ')'){
			return new int[]{result + curr*sign, j};
		}
	}
	return new int[]{result + curr*sign, s.length()};
}
	
	

}
