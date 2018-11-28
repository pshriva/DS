package Twilio;

import java.io.File;
import java.io.FileReader;
import java.util.*;
// Find characters of s not found in t in order
public class Solution {
    
    public static void main(String args[]) throws Exception {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i <s.length() && j < t.length()){
        	int k = i;
        	while(k<s.length() && s.charAt(k) != ' '){k++;}
        	String one = (s.substring(i, k));
        	i = k+1;
        	k = j;
        	while(k < t.length() && t.charAt(k) != ' '){k++;}
        	String two = t.substring(j, k);
        	if(!one.equals(two)){
        		result.add(one);
        	}else{j = k+1;}
        }
        if(i < s.length()){
        	result.addAll(Arrays.asList(s.substring(i).split(" ")));
        }
    	System.out.println(result);
//    	File fr = new File("/Users/pranjali/Desktop/hosts_access_log_00.txt");
//    	Scanner sc = new Scanner(fr);
//    	while(sc.hasNextLine()){
//    		System.out.println(sc.nextLine());
//    	}
//    	sc.close();
    }
}
