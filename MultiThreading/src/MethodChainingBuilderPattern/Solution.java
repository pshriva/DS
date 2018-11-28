package MethodChainingBuilderPattern;
//https://www.geeksforgeeks.org/builder-pattern-in-java/
public class Solution {
	public static void main(String[] args){
		StudentReceiver sr = new StudentReceiver();
		System.out.println(sr.getStudent());
		
	}
}
