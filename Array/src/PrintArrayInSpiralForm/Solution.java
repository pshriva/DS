package PrintArrayInSpiralForm;

import java.util.ArrayList;
import java.util.List;
//LCA
public class Solution {
	public static void main(String args[]){
		int[][] arr = {{1,2,3},{4,5,6}, {7,8,9}};
		List<Integer> result = printInSpiralForm(arr);
		System.out.println(result);
	}

	private static List<Integer> printInSpiralForm(int[][] arr) {
		List<Integer> result = new ArrayList<>();
        if(arr.length == 0){return result;}
        int k = 0;
		int l = 0;
		int m = arr.length - 1;
		int n = arr[0].length - 1;
		while(k <= m && l <= n){
			for(int i = l; i <= n;i++){
                result.add(arr[k][i]);
			}
			k++;
			for(int i = k ; i<=m; i++){
                result.add(arr[i][n]);
			}
			n--;
			if(k <= m){
				for(int i = n; i>=l; i--){
                    result.add(arr[m][i]);
				}
				m--;
			}
			if(l <= n){
				for(int i = m ; i >= k ;i--){
                    result.add(arr[i][l]);
					
				}
				l++;
			}
		}
        return result;
	}
}
