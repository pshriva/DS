package RemoveInvalidParenthesis;
//LCA
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static void main(String[] args){
		String s = "(a)())()";
//		String s = "n";
		List<String> validParenthesis = generateValidParenthesis(s);
		System.out.println(validParenthesis);
	}

	private static List<String> generateValidParenthesis(String s) {
		List<String> result = new ArrayList<>();
		if(s == null){return result;}
		List<String> visited = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(s);
		visited.add(s);
		boolean isFound = false;
		while(!queue.isEmpty()){
			String str = queue.poll();
			if(isValid(str)){
				result.add(str);
				isFound = true;
			}if(isFound)continue;
				for(int i = 0; i< str.length(); i++){
					char c = str.charAt(i);
					if(c != '(' && c != ')')continue;
					String temp = str.substring(0, i) + str.substring(i+1);
					if(!visited.contains(temp)){
						queue.add(temp);
						visited.add(temp);
					}
				}
		}
		return result;
	}

	private static boolean isValid(String str) {
		int count = 0;
		for(int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch == '(')count++;
			if(ch == ')')count--;
			if(count < 0){return false;}
		}
		return count == 0;
	}
}
