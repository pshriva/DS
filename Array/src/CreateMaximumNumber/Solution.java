package CreateMaximumNumber;

public class Solution {
//LCA
	public static void main(String[] args) {
//		int[] nums1 = {3, 4, 6, 5};
//		int[] nums2 = {9, 1, 2, 5, 8, 3};
		int[] nums1 = {6, 7};
		int[] nums2 = {6, 0, 4};
		int k = 5;
		int[] res = getMaxArray(nums1, nums2, k);
		for(int i : res){System.out.print(i + " ");}
	}

	private static int[] getMaxArray(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		for(int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++){
			int[] sub1 = getGreatestSubArray(nums1, i);
			int[] sub2 = getGreatestSubArray(nums2, k-i);
//			System.out.println("SUB1 AND SUB2");
//			for(int n : sub1){System.out.print("	"+n + " ");}
//			System.out.println();
//			for(int n : sub2){System.out.print("	"+n + " ");}
			int[] currMax = new int[k];
			int p1 = 0;
			int p2 = 0;
			int p = 0;
			while(p1 < sub1.length || p2 < sub2.length){
				currMax[p++] = isGreater(sub1, p1, sub2, p2) ? sub1[p1++] : sub2[p2++];
			}
//			while(p1 < sub1.length && p2 < sub2.length){
//				currMax[p++] = isGreater(sub1, p1, sub2, p2) ? sub1[p1++] : sub2[p2++];
//			}
//			while(p1 < sub1.length){
//				currMax[p++] = sub1[p1++];
//			}
//			while(p2 < sub2.length){
//				currMax[p++] = sub2[p2++];
//			}
			if(isGreater(currMax, 0, res, 0)){
				res = currMax;
			}
		}
		return res;
	}

	private static boolean isGreater(int[] sub1, int p1, int[] sub2, int p2) {
		for(; p1 < sub1.length && p2 < sub2.length; p1++, p2++){
			if(sub1[p1] > sub2[p2])return true;
			if(sub1[p1] < sub2[p2])return false;
		}
		return p1 != sub1.length;
	}

	private static int[] getGreatestSubArray(int[] nums, int k) {
		int[] res = new int[k];
		int pointer = 0;
		for(int i = 0; i< nums.length; i++){
			while(pointer > 0 && nums[i] > res[pointer-1] && pointer + nums.length - i > k){
				pointer--;
			}
			if(pointer < k){
				res[pointer++] = nums[i];
			}
		}
		return res;
	}

}
