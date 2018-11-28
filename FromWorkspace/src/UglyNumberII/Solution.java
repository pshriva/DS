package UglyNumberII;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int n = 10;
		int number = getNthUglyNumber(n);
		System.out.println(number);
	}

	
//	Best, O(n) time and O(n) space
//	private static int getNthUglyNumber(int n) {
//		int ugly[] = new int[n];
//		ugly[0] = 1;
//		int index2 = 0, index3 = 0, index5 = 0;
//		int num2 = 2, num3 = 3, num5 = 5;
//		for(int i = 1; i<n; i++){
//			int min = Math.min(num2, Math.min(num3, num5));
//			ugly[i] = min;
//			if(num2 == min){
//				num2 = 2*ugly[++index2];
//			}
//			if(num3 == min){
//				num3 = 3*ugly[++index3];
//			}
//			if(num5 == min){
//				num5 = 5*ugly[++index5];
//			}
//		}
//		return ugly[n-1];
//	}
	
	
//	Accepted, same as above approach, just that indexes and primes are taken in the form of array
	private static int getNthUglyNumber(int n) {
		int[] ugly = new int[n];
		int[] primes = new int[]{2, 3, 5};
		int[] index = new int[primes.length];
		ugly[0] = 1;
		for(int i = 1 ; i<n; i++){
			ugly[i] = Integer.MAX_VALUE;
			for(int j = 0; j<primes.length; j++){
				ugly[i] = Math.min(ugly[i], primes[j]*ugly[index[j]]);
			}
			for(int j = 0; j<primes.length; j++){
				if(ugly[i] == primes[j]*ugly[index[j]]){
					index[j]++;
				}
			}
		}
		return ugly[n-1];
	}
//	Better, but inserting each number in queue is an O(logn) time
//	private static int getNthUglyNumber(int n) {
//		Queue<Long> queue = new PriorityQueue<>();
//		queue.add(1l);
//		for(int i = 1; i<n; i++){
//			long curr = queue.poll();
//			while(!queue.isEmpty() && queue.peek() == curr){queue.poll();}
//			queue.add(curr*2);
//			queue.add(curr*3);
//			queue.add(curr*5);
//		}
//		return queue.poll().intValue();
//	}

	
//	Brute force, Time limit exceeded
//	private static int getNthUglyNumber(int n) {
//		int count = 0;
//		int curr = 0;
//		while(count != n){
//			curr++;
//			int num = curr;
//			System.out.println("num " + num);
//			for(int i = 2; i<6 && num > 0; i++){
//				while(num%i == 0){num =num/i;}
//			}
//			if(num == 1){
//				count++;
//				System.out.println("Is an ugly number so count is " + count);
//			}
//		}
//		
//		return curr;
//	}

}
