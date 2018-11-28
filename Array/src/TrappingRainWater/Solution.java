package TrappingRainWater;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] height = {5,5,1,7,1,1,5,2,7,6};
//		int[] height = {5,4,1,2};
		int waterUnits = getWaterTrapUnits(height);
		System.out.println(waterUnits);
	}

	private static int getWaterTrapUnits(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxLeft = 0;
		int maxRight = 0;
		int waterUnits = 0;
		while(left <= right){
			maxLeft = Math.max(maxLeft, height[left]);
			maxRight = Math.max(maxRight, height[right]);
			if(maxLeft < maxRight){
				waterUnits += (maxLeft - height[left]);
				left++;
			}else{
				waterUnits += (maxRight - height[right]);
				right--;
			}
		}
		return waterUnits;
	}

}
