package FenwickBinaaryIndexedTree;

public class Solution {

	public static void main(String[] args) {
		int[] freq = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
		BinaryIndexedTree bit = new BinaryIndexedTree(12);
		bit.createTree(freq);
		System.out.println();
		System.out.println("Sum of elements in arr[0..5] is " + bit.getSum(5));
		freq[3] += 6;
		bit.update(6, 3);
		System.out.println("Sum of elements in arr[0..5]"+ 
                " after update is " + bit.getSum(5));
	}

}
