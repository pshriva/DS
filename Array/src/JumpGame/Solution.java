package JumpGame;

public class Solution {
	public static void main(String []args){
		int[] arr = {2,2,1,0,4};
		boolean canReachLast = findPath(arr);
		System.out.println(canReachLast);
 	}
//LCA but it takes O(n) space and is approximately of the O(n sq) solution
//	private static boolean findPath(int[] arr) {
////		isPathTo stores true if there is a path to the corresponding index from previous ones
//		boolean[] isPathTo = new boolean[arr.length];
//		isPathTo[0] = true;
//		for(int i = 0; i< arr.length-1; i++){
//			if(isPathTo[i]){
//				for(int j = 1; j <= arr[i]; j++){
//					if(i+j < isPathTo.length){
//						isPathTo[i+j] = true;
//					}
//				}
//			}
//		}
//		return isPathTo[isPathTo.length - 1];
//	}
//BEST, beats 100%
	private static boolean findPath(int[] arr) {
		//This is the last point which is actually the destination, now we can try looking for possible hops, and 0th index must be a hop
		int destination = arr.length - 1;
		for(int i = arr.length-1; i>= 0; i--){
			if(i + arr[i] >= destination){
				destination = i;
			}
		}
		return destination == 0;
	}
}
