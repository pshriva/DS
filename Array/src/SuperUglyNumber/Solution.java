package SuperUglyNumber;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int n = 12;
		int[] primes = {2, 7, 13, 19};
		int uglyNumber = getNthSuperUglyNumber(n, primes);
		System.out.println(uglyNumber);
	}

	
//	O(kn), k = size of primes array and n = given number n
//	private static int getNthSuperUglyNumber(int n, int[] primes) {
//		int[] ugly = new int[n];
//		int[] index = new int[primes.length];
//		ugly[0] = 1;
//		for(int i = 1 ; i<n; i++){
//			ugly[i] = Integer.MAX_VALUE;
//			for(int j = 0; j<primes.length; j++){
//				ugly[i] = Math.min(ugly[i], primes[j]*ugly[index[j]]);
//			}
//			for(int j = 0; j<primes.length; j++){
//				if(ugly[i] == primes[j]*ugly[index[j]]){
//					index[j]++;
//				}
//			}
//		}
//		return ugly[n-1];
//	}
	
	private static int getNthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n+1];
        ugly[0]=1;
        int[] pointer = new int[primes.length];
        for(int i=1;i<n;i++) {
            int min=Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j=0;j<primes.length;j++) {
                if(ugly[pointer[j]]*primes[j]<min) {
                    min=ugly[pointer[j]]*primes[j];
                    minIndex = j;
                }else if(ugly[pointer[j]]*primes[j]==min) {
                    pointer[j]++;
                }
            }
            ugly[i]=min;
            pointer[minIndex]++;
        }
        return ugly[n-1];
	}

}
