package NonDecreasingArray;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] arr = {2,3,4,7,19, 12, 13, 15};
		boolean isNonDecreasing = getNonDecreasing(arr);
		System.out.println(isNonDecreasing);
	}
//LCA
	private static boolean getNonDecreasing(int[] arr) {
		int count = 0;
		for(int i = 0;i<arr.length-1; i++){
			if(arr[i] > arr[i+1]){
				count++;
				if(count > 1){return false;}
				if((i-1)< 0 || arr[i-1] <= arr[i+1]){
					arr[i] = arr[i+1];
				}else{
					arr[i+1] = arr[i];
				}
			}
		}
		return count <= 1;
	}
	
	
//LCA
//	private static boolean getNonDecreasing(int[] arr) {
//		int count = 0;
//		for(int i = 0;i<arr.length-1; i++){
//			if(arr[i] > arr[i+1]){
//				count++;
//				if(count > 1){return false;}
//				if((i-1)< 0 || arr[i-1] <= arr[i+1]){
//					arr[i] = arr[i+1];
//				}else{
//					arr[i+1] = arr[i];
//				}
//			}
//		}
//		return count <= 1;
//	}

	
}
