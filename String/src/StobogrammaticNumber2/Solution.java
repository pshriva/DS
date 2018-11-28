package StobogrammaticNumber2;

import java.util.*;

// LL : Find all stobogram atic numbers of length n
public class Solution {
	public static void main(String args[]){
//		int n= 5;
		int n = 3;
		List<String> numbers = getStobogrammaticNumbers(n);
		System.out.println(numbers);
	}

	//Iterative
		private static List<String> getStobogrammaticNumbers(int n) {
			List<String> result;
			Map<String, String> map = new HashMap<>();
			map.put("0", "0");
			map.put("1", "1");
			map.put("6", "9");
			map.put("8", "8");
			map.put("9", "6");
			if(n == 0){return new ArrayList<>();}
			if(n%2 == 0){
				result = new ArrayList<>();
				result.add("");
			}else{
//				6 or 9 cannot be the mid number as they are compliments of each other when rotated 
//				and do not remain same so cannot be the mid number
				result = new ArrayList<>(Arrays.asList("0","1","8"));
			}
			for(int i = 1; i<=n/2 ; i++){
				List<String> temp = new ArrayList<>();
				for(String s : result){
					for(String key : map.keySet()){
//						To avoid numbers that start and end with 0 (since not exactly a valid number)
						if(i == n/2 && key.equals("0")){continue;}
						String curr = key + s + map.get(key);
						temp.add(curr);
					} 
				}
				result = temp;
			}
			return result;
		}
//	Recursive
//	private static List<String> getStobogrammaticNumbers(int n) {
//		return getStrobogrammaticNumbers(n, n);
//	}
//
//
//	private static List<String> getStrobogrammaticNumbers(int left, int total) {
//		if(left == 0){return Arrays.asList("");}
//		if(left == 1){return Arrays.asList("0", "1", "8");}
//		List<String> temp = getStrobogrammaticNumbers(left-2, total);
//		List<String> result = new ArrayList<>();
//		for(int i = 0; i < temp.size(); i++){
//			String curr = temp.get(i);
//			if(left != total){
//				result.add("0" + curr + "0");
//			}
//			result.add("1" + curr + "1");
//			result.add("6" + curr + "9");
//			result.add("8" + curr + "8");
//			result.add("9" + curr + "6");
//		}
//		return result;
//	}
	
}
