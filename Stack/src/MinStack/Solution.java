package MinStack;
//LCA
public class Solution {
	public static void main(String args[]){
		MinStack stack = new MinStack();
		stack.push(-1);
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.getMin());
	}
}
