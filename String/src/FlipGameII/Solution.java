package FlipGameII;

import java.util.*;

public class Solution {
	public static void main(String args[]){
		String s = "+++++++++";
		boolean canWin = canWin(s);
		System.out.println(canWin);
	}
	
	
//	DFS 
	private static boolean canWin(String s) {
		for(int i = 1; i<s.length(); i++){
			if(s.charAt(i) == s.charAt(i-1) && s.charAt(i) == '+' && !canWin(s.substring(0, i-1) + "--" + s.substring(i+1))){
				return true;
			}
		}
		return false;
	}
	
	
//	Another variant in for loop for the DFS
//	private static boolean canWin(String s) {
//		for(int i = 0; i<s.length()-1; i++){
//			if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '+' && !canWin(s.substring(0, i) + "--" + s.substring(i+2))){
//				return true;
//			}
//		}
//		return false;
//	}
	
	
//	Same DFS, just optimized
//	public boolean canWin(String s) {
//	    if (s == null || s.length() < 2) {
//	        return false;
//	    }
//	    HashMap<String, Boolean> winMap = new HashMap<String, Boolean>();
//	    return helper(s, winMap);
//	}
//
//	public boolean helper(String s, HashMap<String, Boolean> winMap) {
//	    if (winMap.containsKey(s)) {
//	        return winMap.get(s);
//	    }
//	    for (int i = 0; i < s.length() - 1; i++) {
//	        if (s.startsWith("++", i)) {
//	            String t = s.substring(0, i) + "--" + s.substring(i+2);
//	            if (!helper(t, winMap)) {
//	                winMap.put(s, true);
//	                return true;
//	            }
//	        }
//	    }
//	    winMap.put(s, false);
//	    return false;
//	}
	
	

	
	
//	BFS, WRONG ONE
//	private static boolean canWin(String s) {
//		if(s == null || s.length() <2){return false;}
//		Queue<String> queue = new LinkedList<>();
//		queue.add(s);
//		int count = 0;
//		while(!queue.isEmpty()){
//			int size = queue.size();
//			++count;
//			for(int i = 0; i < size; i++){
//				String curr = queue.poll();
//				boolean couldPlay = false;
//				for(int j = 0; j < curr.length()-1; j++){
//					if(curr.charAt(j) == curr.charAt(j+1) && curr.charAt(j) == '+'){
//						couldPlay = true;
//						String str = curr.substring(0, j) + "--" + curr.substring(j+2);
//						queue.add(str);
//					}
//				}
//				if(!couldPlay && count % 2 == 0){return true;}
//			}
//		}
//		return false;
//	}
}
