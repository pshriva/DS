package UglyNumber;
//LCA
public class Solution {

	public static void main(String[] args) {
		int n = 7;
		boolean isUgly = findUgly(n);
		System.out.println(isUgly);
	}

	public static boolean findUgly(int n) {
		 if(n <= 0){return false;}
	     while(n%2 == 0){n = n/2;}
	     while(n%3 == 0){n = n/3;}
	     while(n%5 == 0){n = n/5;}
	     return n == 1;
	}
	
//	public static boolean findUgly(int n) {
//        if(n <= 0){return false;}
//        for(int i = 2; i< 6; i++){
//            while(n% i == 0){
//                n = n/i;
//            }
//        }
//        return n == 1;
//    }
	
}
