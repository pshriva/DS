package BaseBallGame;

import java.util.Stack;
// LCA
public class Solution {
	public static void main(String[] args){
		String[] operations = {"5","-2","4","C","D","9","+","+"};
		int score = getScore(operations);
		System.out.println(score);
	}

	private static int getScore(String[] operations) {
		Stack<Integer> stack = new Stack<>();
		int score = 0;
		int currentScore = 0;
		for(String s : operations){
			if(s.equals("+")){
				int lastPoint = stack.pop();
				currentScore = lastPoint + stack.peek();
				stack.push(lastPoint);
			}else if(s.equals("D")){
				currentScore = 2*stack.peek();
			}else if(s.equals("C")){
				score = score - stack.pop();
				currentScore = Integer.MIN_VALUE;
			}else{
				currentScore = Integer.parseInt(s);
			}
			if(currentScore != Integer.MIN_VALUE){
				stack.push(currentScore);
				score = score + currentScore;
			}
		}
		return score;
	}
}
