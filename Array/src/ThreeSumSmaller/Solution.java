package ThreeSumSmaller;
//http://www.cnblogs.com/grandyang/p/5235086.html
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {-2, 0, 1, 0,0,0};
		int target = -1;
		int count = get3SumSmallerPairsCount(arr, target);
		System.out.println(count);
	}
	
	
	
	
	private static int get3SumSmallerPairsCount(int[] arr, int target) {
		Arrays.sort(arr);
		int count = 0;
		for(int i = 0; i < arr.length - 2; i++){
			if(i > 0 && arr[i] == arr[i-1]){continue;}
			int left = i+1;
			int right = arr.length - 1;
//			Set<Integer> set = new HashSet<>();
			while(left < right){
				int sum = arr[i] + arr[left] + arr[right];
				if(sum < target){
//					count-- so that the count++ in case of duplicates nullifies the value
					if(right < arr.length - 1 && arr[right] == arr[right+1]){count--;}
					count++;
				}
				right--;
			}
		}
		return count;
	}

//	http://www.cnblogs.com/grandyang/p/5235086.html
//	If duplicates aare allowed:
	
//	O(n^2),
//	there is a trick here.
//	When the sum of the three numbers is less than the target value,
//	the result should be added as (right-left) since, After the array is sorted, 
//	if num[right] is added to the target value,
//	then adding a smaller number will also Less than the target value,
//	then we shift the left pointer to the right by one,
//	otherwise we will shift the right pointer to the left by one bit, see the code below:
	

//	class Solution {
//		public:
//		    int threeSumSmaller(vector<int>& nums, int target) {
//		        if (nums.size() < 3) return 0;
//		        int res = 0, n = nums.size();
//		        sort(nums.begin(), nums.end());
//		        for (int i = 0; i < n - 2; ++i) {
//		            int left = i + 1, right = n - 1;
//		            while (left < right) {
//		                if (nums[i] + nums[left] + nums[right] < target) {
//		                    res += right - left;
//		                    ++left;
//		                } else {
//		                    --right;
//		                }
//		            }
//		        }
//		        return res;
//		    }
//		};

}
