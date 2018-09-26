package LongestAbsoluteFilePath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//LCA
public class Solution {
	public static void main(String []args){
//		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		String input = "a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt";
//		int longestPath = getLongestFilePath(input);
//		System.out.println(longestPath);
	}

	private static int getLongestFilePath(String input) {
		String[] files = input.split("\n");
		Stack<Integer> stack = new Stack<>();
		int currentLength = 0;
		int maxLength = 0;
		for(String s : files){
			int level = s.length() - s.replaceAll("\t", "").length();
			while(stack.size() > level){
				currentLength -= stack.pop();
			}
			int length = s.replaceAll("\t", "").length() + 1; //(+1 for '/' between files in path as- D/document/file.txt)
			currentLength += length;
			if(s.contains(".")){
				maxLength = Math.max(maxLength, currentLength-1);// -1 bcz last file does not have '/'
			}
			stack.push(length);
		}
		return maxLength;
	}
}
