package ArithematicSlices;
//LCA, OS
public class Solution {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 10, 11, 12};
		int result = getAllArithematicSlices(arr);
		System.out.println("result " + result);
	}

	private static int getAllArithematicSlices(int[] arr) {
		if(arr.length < 3){return 0;}
		//total number of sequences as sum
		int sum = 0;
		//store diff between 1st two elements
		int diff = arr[0] - arr[1];
		//store how many elements have been considered as len
		int len = 2;
		// difference between 0th and 1st element is stored, so start for index 1 now
		int i = 1;
		while(i<arr.length-1){
			// see how long this sequence goes and keep the count of length
			while(i < arr.length-1 && arr[i] - arr[i+1] == diff){
				i++;
				len++;
			}
			//if this len is < 3 then no sequence is formed else-
			if(len >= 3){
				/*
				 * this formula can be explained as -
				 * if len == 3 means only 3 elements means sum = 1
				 * if len == 4  means 3 sequences: (2) + (1) as - 
				 * 		of len 3 - abc, bcd (2)
				 * 		of len 4 - abcd (1)
				 * if len == 5, means 6 sequences (3) + (2) + (1), as - 
				 * 		of len 3 - abc, bcd, cde, (3)
				 * 		of len 4 - abcd, bcde (2)
				 * 		of len 5 - abcde (1),
				 * 
				 * so basically the pattern is - for len = 4, its sum of 1st 2 natural numbers 
				 * 								 for len = 5, its sum of 1st 3 natural numbers
				 * basically for len = n, its sum of 1st (n- 3 + 1) natural numbers.
				 * That is so because, if we consider 1st n natural number taking 1 number at a time, total numbers = n
				 * hence, for 1st n natural numbers we are taking 3 numbers at a time, so total number sequences = (n-3) (since the numbers can overlap)
				 * And +1 for the whole sequence as 1
				 */
				sum = sum + (len-3+1)*(len-3+1+1)/2;
			}
//			If there are more elements in array, then find another new difference and see how far this series go with the upper while loop			
			if(i < arr.length-1){
				diff = arr[i] - arr[i+1];
				i++;
				len = 2;
			}
		}
		return sum;
	}

}
