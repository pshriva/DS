package SimplifyPath;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
		String path = "/pKpGC/.././l/U/../././AM/../././//..///..///ov/../..///zy/././k//";
		String result = simplifyPath(path);
		System.out.println(result);
	}

// 	Without using stack and taking no extra space
//	https://leetcode.com/problems/simplify-path/discuss/171519/Two-solutions-with-stack-and-without-stack
	
//Using stack and taking no extra space
	private static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		int i = 0;
		while(i  < path.length()){
			while(i < path.length() && path.charAt(i) == '/'){
				i++;
			}
			if(i < path.length() && path.charAt(i) == '.'){
				int count = 0;
				int j = i;
				//boolean to check if the string is something like - ..sdd.. (bcz then its a folder name)
				boolean hasOtherCharacter = false;
				while(j < path.length() && path.charAt(j) != '/'){
					if(path.charAt(j) != '.'){hasOtherCharacter = true;}
					j++;
					count++;
				}
				if(count == 2 && !stack.isEmpty() && !hasOtherCharacter){stack.pop();}
				//else if for cases like - /.h  || //...
				else if((count > 1 && hasOtherCharacter) || (count > 2)){
					stack.push(path.substring(i, j));
				}
				i = j;
			}else  if(i < path.length()){
				int j = i;
				while(j < path.length() && path.charAt(j) != '/' && path.charAt(j) != '.'){j++;}
				stack.push(path.substring(i, j));
				i = j;
			}
		}
		List<String> list = new ArrayList<>(stack);
		return "/" + String.join("/", list); 
	}

//  Using stack and taking extra space	
//	private static String simplifyPath(String path) {
//		Stack<String> stack = new Stack<>();
//		String[] p = path.split("/");
//		for(int i = 0; i<p.length; i++){
//			if(p[i].equals("..") && !stack.isEmpty()){stack.pop();}
//			else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
//				stack.push(p[i]);
//			}
//		}
//		List<String> list = new ArrayList<>(stack);
//		return "/" + String.join("/", list);
//	}
}
