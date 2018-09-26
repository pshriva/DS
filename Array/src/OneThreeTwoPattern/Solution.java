package OneThreeTwoPattern;

import java.util.Stack;
//LCA
public class Solution {
	public static void main(String []args){
		int[] arr = {-2,1,2,-2,1,2};
		boolean is132 = findPattern(arr);
		System.out.println(is132);
	}

	private static boolean findPattern(int[] arr) {
		Stack<Integer> stack = new Stack<>();
        int three = Integer.MIN_VALUE;
        for(int i = arr.length - 1; i>= 0; i--){
            if(arr[i] < three){return true;}
            while(!stack.isEmpty() && arr[i] > stack.peek()){
                three = stack.pop();
            }
            stack.push(arr[i]);
        }
        return false;
	}
}
