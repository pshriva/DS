package MoveZeroes;
//LCA
public class Solution {
	public static void main(String[] args){
		int[] arr = {0,1,0,3,12};
		moveZeroes(arr);
		for(int i : arr){
			System.out.print(i + " ");
		}
	}

	private static void moveZeroes(int[] arr) {
		int left = 0;
		for(int i = 0; i< arr.length ; i++){
			if(arr[i] != 0 && arr[left] == 0){
				arr[left] = arr[i];
				left++;
				arr[i] = 0;
			}else if(arr[left] != 0 && arr[i] == 0){left = i;}
		}
	}
}
