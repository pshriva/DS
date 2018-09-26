package CountPrimes;
//LCA
public class Solution {
	public static void main(String[] args){
		int n = 2;
		int numberOfPrimes = getNumberOfPrimes(n);
		System.out.println(numberOfPrimes);
	}

	private static int getNumberOfPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for(int i = 2; i<n; i++){
			if(notPrime[i] == false){
				count++;
				for(int j = i*2; j<n; j = j+i){
					notPrime[j] = true;
				}
			}
		}
		return count;
	}
}
