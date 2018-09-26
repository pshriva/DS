package BinaryGap;
//LCA
public class Solution {

	public static void main(String[] args) {
		int number = -22;
		int binaryGap = getBinaryGap(number);
		System.out.println(binaryGap);
	}

	private static int getBinaryGap(int number) {
		int maxDistance = 0;
		int count = 0;
		boolean increaseCount = false;
		while(number > 0){
			if((number & 1) == 1){
				maxDistance = Math.max(maxDistance, count);
				count = 0;
				increaseCount = true;
			}
			number = number >>1;
			if(increaseCount)count++;
		}
		return maxDistance;
	}

}
