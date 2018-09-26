package AdvantageShuffleTreeMap;

import java.util.Map;
import java.util.TreeMap;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int[] brr = {1,10,4,11};
		int[] result = getAdvantageousArray(arr, brr);
		for(int i : result){
			System.out.print(i + " ");
		}
	}

	private static int[] getAdvantageousArray(int[] arr, int[] brr) {
		int[] result = new int[arr.length];
		int k = 0;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i : arr){
			if(map.containsKey(i)){
				map.put(i, map.get(i) + 1);
			}else{
				map.put(i, 1);
			}
		}
		for(int i : brr){
			Map.Entry<Integer, Integer> value = map.higherEntry(i);
			if(value == null){
				value = map.firstEntry();
			}
			result[k++] = value.getKey();
			if(value.getValue() == 1){
				map.remove(value.getKey());
			}else{
				map.put(value.getKey(), value.getValue()-1);
			}
		}
		return result;
	}

}
