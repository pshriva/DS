package AmbiguousCoordinates;

import java.util.ArrayList;
import java.util.List;
//LCA
public class Solution {
	public static void main(String args[]){
		String str = "(000110)";
		List<String> result = getXYCoordinates(str);
		System.out.println(result);
	}

	private static List<String> getXYCoordinates(String S) {
		List<String> result = new ArrayList<>();
        //starting with 2 and ending with -1 bcz the string is already surrounded by '()'
        // and we do not want to take those into consideration
        for(int i = 2; i<S.length()-1; i++){
            List<String> xc = createXY(S.substring(1, i));
            List<String> yc = createXY(S.substring(i, S.length()-1));
            for(String x : xc){
                for(String y : yc){
                    result.add("(" + x + ", " + y + ")");
                }
            }
        }
        return result;
	}

	private static List<String> createXY(String str) {
		List<String> result = new ArrayList<>();
        int n = str.length();
        // 0xxxx0
        if(n > 1 && str.charAt(0) == '0' && str.charAt(n-1) == '0'){
            return result;
        }
        // single str or xxxx0 , we cannot place a point in such case
        if(n == 1 || str.charAt(n-1) == '0'){
            result.add(str);
            return result;
        }
        //0xxxx
        if(str.charAt(0) == '0'){
            result.add("0." + str.substring(1));
            return result;
        }
        //xxxx
        result.add(str);
        for(int i = 1; i<str.length(); i++){
            result.add(str.substring(0, i) + "." + str.substring(i));
        }
        return result;
	}
}
