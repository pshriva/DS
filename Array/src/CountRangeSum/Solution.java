package CountRangeSum;

import java.util.*;

public class Solution {
	public static void main(String args[]){
		int nums[] = {-2,5,-1};
		int lower = -2;
		int upper = 2;
		int result = countRangeSum(nums, lower, upper);
	}

	private static int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
        //map discrete sum plus boundrays into a hashMap, which would be used to build BIT and map nums to index
        Map<Long, Integer> map = countSum(nums, lower, upper);
        System.out.println(map.size());
        //BIT to lower <= sum[j] - sum[i] <= upper, so  sum[j] - upper <= sum[i] <= sum[j] - lower, perfect for BIT to record and query counts. 
        BinaryIndexTree bit = new BinaryIndexTree(map.size());
        bit.update(map.get(0L), 1);
        int ans = 0;
        long sum = 0;
        for (int i : nums) {
            sum += (long)i;
            ans += bit.query(map.get(sum - (long)upper), map.get(sum - (long)lower));
            bit.update(map.get(sum), 1);
        }
        return ans;
	}
	
	public static Map<Long, Integer> countSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long sum = 0;
        Set<Long> hash = new HashSet<>();
        hash.add(0L);
        hash.add(-(long)lower);
        hash.add(-(long)upper);
        for (int i : nums) {
            sum += (long)i;
            hash.add(sum);
            hash.add(sum - (long)lower);
            hash.add(sum - (long)upper);
        }
        List<Long> list = new ArrayList<>(hash);
        Collections.sort(list);
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        for (long i : list) {
            map.put(i, index++);
        }
        return map;
    }
	
	
	static class BinaryIndexTree {
        int[] counts;
        int size;
        
        public BinaryIndexTree(int n) {
            size = n + 1;
            counts = new int[size];
        }
        
        public void update(int i, int val) {
            ++i;
            while (i < size) {
                counts[i] += val;
                i += Integer.lowestOneBit(i);
            }
        }
        
        public int sum(int i) {
            ++i;
            int ans = 0;
            while (i > 0) {
                ans += counts[i];
                i -= Integer.lowestOneBit(i);
            }
            return ans;
        }
        
        public int query(int i, int j) {
            return sum(j) - sum(i - 1);
        }
    }
	
	
	
//	Understood a some
//	http://shirleyisnotageek.blogspot.com/2016/10/count-of-range-sum.html

//	private static int countRangeSum(int[] nums, int lower, int upper) {
//		int len = nums.length;
//        if (lower > upper || len <= 0) {
//            return 0;
//        }
//        long[] sums = new long[len];
//        sums[0] = nums[0];
//        for (int i = 1; i < len; i++) {
//            sums[i] = sums[i - 1] + nums[i];
//        }
//        return getCount(nums, 0, len - 1, sums, lower, upper);
//	}
//
//	 private static int getCount(int[] nums, int left, int right, long[] sums, int lower, int upper) {
//	        if (left > right) {
//	            return 0;
//	        }
//	        if (left == right) {
//	            if (nums[left] <= upper && nums[left] >= lower) {
//	                return 1;
//	            } else {
//	                return 0;
//	            }
//	        }
//	        int mid = (left + right) / 2;
//	        int count = 0;
//	        for (int i = left; i <= mid; i++) {
//	            for (int j = mid + 1; j <= right; j++) {
//	                //sums[i] = 0 to i sum, inclusive
//	                // sums[j] = 0 to j sum, inclusive
//	                //sums[j] - sums[i] i + 1 to j sum
//	                //so we need to add nums[i] back
//	                long tmp = sums[j] - sums[i] + nums[i];
//	                if ( tmp <= upper && tmp >= lower) {
//	                    count++;
//	                }
//	            }
//	        }
//	        return count + getCount(nums, left, mid, sums, lower, upper) + getCount(nums, mid + 1, right, sums, lower, upper);
//	    }
}
