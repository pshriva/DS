package SqrtX;

public class Solution {

	public static void main(String[] args) {
		int x = 2147395599;
		int sqrt = getSqrt(x);
		System.out.println(sqrt);
	}

	private static int getSqrt(int x) {
		if(x <= 1){return x;}
		int left = 1;
		int right = x/2;
		int ans = 0;
		while(left <= right){
			long mid = left + (right-left)/2;
			long temp = mid*mid;
			if(temp == x){return (int)mid;}
			else{
				if(temp < x){
					left = (int)mid+1;
					ans = (int)mid;
				}else{
					right = (int)mid-1;
				}
			}
		}
		return ans;
	}

}
