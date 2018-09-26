package ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;
//LCA
public class Solution {
	public static void main(String[] args){
		String num = "232";
		int target = 8;
		List<String> list = getTargetExpressions(num, target);
		System.out.println(list);
	}

	private static List<String> getTargetExpressions(String num, int target) {
		if(num == null || num.length() == 0){return new ArrayList<String>();}
		int n = num.charAt(0) - '0';
		String s = "";
		List<String> expressions = new ArrayList<>();
		getOperations(num, s, expressions, 0, target, 0, 0);
		return expressions;
	}

	private static void getOperations(String num, String s, List<String> expressions, int start, int target, long sum, long prev) {
		if(start == num.length()){
			if(sum == target){
				expressions.add(s);
			}
			return;
		}
		for(int i = start; i< num.length(); i++){
			if(start != i && num.charAt(start) == '0')break;
			long current = Long.parseLong(num.substring(start, i+1));
			if(start == 0){
				getOperations(num, s+ current, expressions, i+1, target, sum + current, current);
			}else{
				getOperations(num, s + "+" + current, expressions, i+1, target, sum + current, current);
				getOperations(num, s + "-" + current, expressions, i+1, target, sum - current, - current);
				getOperations(num, s + "*" + current, expressions, i+1, target, sum - prev + prev * current, prev *current);
			}
		}
	}
}
