package PaintFence;

public class Solution {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		int ways = getNumberOfWaysToPaint(n, k);
		System.out.println(ways);
	}

//	private static int getNumberOfWaysToPaint(int n, int k) {
//		if (n == 0 ) return  0 ;
//        int same = 0 , diff = k, res = same + diff;
//        for ( int i = 2 ; i <= n; ++ i) {
//           same = diff;
//           diff = res * (k - 1 );
//           res = same + diff;
//       }
//       return res;
//	}
	
//	We can paint the current tile of same color as prev one only when the prev was painted as different than its prev tile's color, 
//	Else they would be 3 in the same row for the same color
	private static int getNumberOfWaysToPaint(int n, int k) {
		if(n == 0){return 0;}
		int samePaint = 0;
		int differentPaint = k;
		int result = samePaint + differentPaint;
		for(int i = 2; i <= n ; i++){
//			ways of painting the current tile as of same color ass prev = ways of painting the prev in diff color than its prev colored tile
			samePaint = differentPaint;
			differentPaint = result * (k-1);
			result = samePaint + differentPaint;
		}
		return result;
	}

}
