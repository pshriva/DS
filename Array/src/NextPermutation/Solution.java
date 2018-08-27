package NextPermutation;

public class Solution {
	public static void main(String args[]) {
		int[] nums = {1,5,1};
		getNextPermutation(nums);
		for(int i : nums) {System.out.print(i);}
	}

	private static void getNextPermutation(int[] nums) {
		int index = nums.length - 1;
		int left = 0;
		int right = nums.length - 1;
		while(index > 0) {
			if(nums[index] > nums[index-1]) {
				int curr = nums.length - 1;
				while(curr >= index && nums[curr] <= nums[index-1]) {
					curr--;
				}
				int temp = nums[curr];
				nums[curr] = nums[index-1];
				nums[index-1] = temp;
				left = index;
				break;
			}
			index--;
		}
		//if no next permutation could be obtained then reverse the number or if permutation is formed then reverse the number from left = 'index'
		while(left <= right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
}
