package MinStackk;

import java.util.Stack;

public class MinStack {
	Stack<Wrap> stack;
	public MinStack(){
		stack = new Stack<Wrap>();
	}
	public void push(int x){
		if(stack.size() == 0){stack.push(new Wrap(x,x));}
		else{
			int min = Math.min(x, stack.peek().min);
			stack.push(new Wrap(x, min));
		}
	}
	
	public void pop() {
        stack.pop();
    }
	
	public int top() {
        return stack.peek().val;
    }
	
	public int getMin() {
        return stack.peek().min;
    }
	public class Wrap{
		int val;
		int min;
		public Wrap(int val, int min){
			this.val = val;
			this.min = min;
		}
	}
}
