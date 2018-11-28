package AddTwoIntegers;

public class Solution {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int sum = add(a,b);
		System.out.println(sum);
		System.out.println();
	}

	private static int add(int a, int b) {
		if(b == 0){return a;}
		int sum = a^b;
		int carry = (a&b) <<1;
		return add(sum, carry);
	}

}
