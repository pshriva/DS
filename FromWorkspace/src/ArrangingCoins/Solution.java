package ArrangingCoins;
//LCA
public class Solution {
	public static void main(String []args){
		int n = 0;
		int stairs = getStairs(n);
		System.out.println(stairs);
	}

	private static int getStairs(int n) {
		int count = 0;
		while(n >= count){
			n = n-count;
			count++;
		}
		return count-1;
	}
}
