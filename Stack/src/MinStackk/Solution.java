package MinStackk;
//LCA
public class Solution {

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-3);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.top());
		System.out.println(m.getMin());
	}

}
