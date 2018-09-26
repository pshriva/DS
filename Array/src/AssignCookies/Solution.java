package AssignCookies;

import java.util.Arrays;
//LCA
public class Solution {
	public static void main(String [] args){
		int [] g = {10,7,9,8};
		int [] c = {7,5,6,8};
		int result = findContentChildren(g, c);
		System.out.println(result);
	}

	private static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while(child < g.length && cookie < s.length){
            if(g[child] <= s[cookie]){
                child++;
                cookie++;
            }else{
                cookie++;
            }
        }
        return child;
	}
}
