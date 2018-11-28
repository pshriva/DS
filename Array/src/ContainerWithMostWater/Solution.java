package ContainerWithMostWater;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		int units = getMostWater(height);
		System.out.println(units);
	}

	private static int getMostWater(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxUnits = 0;
		while(left < right){
			int minHeight = Math.min(height[left], height[right]);
			maxUnits = Math.max(maxUnits, minHeight * (right - left));
			if(height[left] == minHeight){left++;}
			else{right--;}
		}
		return maxUnits;
	}

}
