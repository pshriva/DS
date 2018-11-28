package SlidingWindowMaximum;
// Bad idea, almost O(k*n) in worst case
class Solution2 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0)
			return new int[0];
		int[] res = new int[nums.length - k + 1];
		res[0] = Integer.MIN_VALUE;
		int pos = -1;
		for (int i = 0; i < k; i++) {
			if (res[0] < nums[i]) {
				res[0] = nums[i];
				pos = i;
			}
		}
		for (int i = 1; i + k <= nums.length; i++) {
			if (nums[i + k - 1] >= nums[pos]) {
				pos = i + k - 1;
			} else if (i > pos) {
				pos = i;
				for (int j = i + 1; j < i + k; j++) {
					if (nums[j] > nums[pos])
						pos = j;
				}
			}
			res[i] = nums[pos];
		}
		return res;
	}
}