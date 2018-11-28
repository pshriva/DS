package AashiVA;

import java.util.*;

public class Solution {
	public static void main(String[] args){
		int workHours = 3;
		int dayHours = 2;
		String pattern = "??2??00";
//		int[] arr = {0, 0, 0, 0, 0, 1, 2};
		List<String> schedule = findSchedules(workHours, dayHours, pattern);
		System.out.println(schedule);
	}

	private static List<String> findSchedules(int workHours, int dayHours, String pattern) {
		Set<String> res = new HashSet<>();
		List<String> result = new ArrayList<>();
		List<List<Integer>> pms = new ArrayList<>();
		int remainingHours = workHours;
		int count = 0;
		for(int i = 0; i<pattern.length(); i++){
			char ch = pattern.charAt(i);
			if(ch == '?'){count++;}
			else{
				remainingHours = remainingHours - ((int)(ch) - 48);
			}
		}
		if(remainingHours >= count){
			int[] permutation = new int[count];
			int hours = remainingHours/count;
			Arrays.fill(permutation, hours);
			if(remainingHours%count != 0){
				int remainder = remainingHours%count;
				int incrementBy = (dayHours - permutation[0]);
				for(int i = 0; i<permutation.length; i++){
					if(remainder == 0){break;}
					if(remainder >= incrementBy){
						permutation[i] += incrementBy;
						remainder -= incrementBy;
					}else{
						permutation[i] += remainder;
						remainder = 0;
						break;
					}
				}
			}
			List<int[]> combinations = getCombinations(permutation, dayHours);
			for(int[] arr : combinations){
				List<List<Integer>> pm = subsetsWithDup(arr);
				pms.addAll(pm);
			}
		}
		///
		else{
			int[] permutation = new int[count];
			if(remainingHours < dayHours){
				permutation[count-1] = remainingHours;
			}else{
				for(int i = 0; i<permutation.length; i++){
					if(remainingHours <= dayHours){
						permutation[i] = remainingHours;
						remainingHours = 0;
						break;
					}
					permutation[i] = dayHours;
					remainingHours = remainingHours - dayHours;
					if(remainingHours <= 0){break;}
				}
			}
			List<int[]> combinations = getCombinations(permutation, dayHours);
			for(int[] arr : combinations){
				List<List<Integer>> pm = subsetsWithDup(arr);
				pms.addAll(pm);
			}
		}
		for(List<Integer> list : pms){
			String curr = getSequence(list, pattern);
			res.add(curr);
		}
		result.addAll(res);
		return result;
	}

	private static String getSequence(List<Integer> list, String pattern) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i<pattern.length() ; i++){
			if(pattern.charAt(i) != '?'){
				result.append(pattern.charAt(i));
			}else{
				result.append(list.remove(0));
			}
		}
		return result.toString();
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
	    return list;
	}
	
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
	    if(tempList.size() == nums.length){
	        list.add(new ArrayList<>(tempList));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}

	private static List<int[]> getCombinations(int[] permutation, int dayHours) {
		List<int[]> result = new ArrayList<>();
		result.add(permutation);
		for(int i = 0; i< permutation.length-1; i++){
			if(permutation[i] == dayHours){
				continue;
			}
			int j = i;
			while(permutation[j] < dayHours && permutation[j+1] > 0){
				permutation[j] += 1;
				permutation[j+1] -= 1;
				result.add(permutation.clone());
			}
		}
		return result;
	}
}
