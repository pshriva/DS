package CountOfSmallerNumberAfterSelf;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
		int []nums = new int[]{5,2,6,1};
		List<Integer> count = getCount(nums);
		System.out.println(count);
	}

	private static List<Integer> getCount(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 0){return result;}
		Node root = new Node(nums[nums.length - 1]);
		result.add(0, 0);
		for(int i = nums.length - 2; i>= 0; i--){
			int count = getCount(root, nums[i]);
			result.add(0, count);
		}
		return result;
	}

	private static int getCount(Node root, int num) {
		int count = 0;
		Node curr = new Node(num);
		while(root != curr){
			if(curr.val <= root.val){
				root.count++;
				if(root.left == null){
					root.left = curr;
					root = curr;
				}else{
					root = root.left;
				}
			}else{
				count += root.count+1;
				if(root.right == null){
					root.right = curr;
					root = curr;
				}else{
					root = root.right;
				}
			}
		}
		
		return count;
	}

}
