package ClimbingStairs;

public class Solution {
	public static void main(String[] args) {
		int stairs = 5;
		int ways = getWaysToClimb(stairs);
		System.out.println(ways);
	}

	private static int getWaysToClimb(int stairs) {
		if(stairs <= 1) {return 1;}
		int last = 1;
		int secondlast = 1;
		int current = 0;
		for(int i = 3; i<=stairs+1; i++) {
			current = secondlast + last;
			secondlast = last;
			last = current;
		}
		return current;
	}
}
