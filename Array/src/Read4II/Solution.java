package Read4II;

import java.util.*;

public class Solution {
	static Read4 r = new Read4("abcdefghijklmnopqrstuvwxyz");
	static List<Character> buffer = new ArrayList<>();
	public static void main(String[] args) {
		
//		1st call to read function
		int n = 5;
		char[] buf = new char[5];
		int read = read(buf, n);
		System.out.println(read);
		for(char c : buf){System.out.print(c + " ");}
		System.out.println();
		
//		2nd call to read function
		int n2 = 30;
		char[] buf2 = new char[30];
		int read2 = read(buf2, n2);
		System.out.println(read2);
		for(char c : buf2){System.out.print(c + " ");}
		System.out.println();
	}
	private static int read(char[] buf, int n) {
		int index = 0;
		while(index < n){
			char[] temp = new char[4];
			int count = r.read4(temp);
			if(count == 0){break;}
			for(char c : temp){buffer.add(c);}
			for(int i = 0; i < count && index < n; i++){
				buf[index++] = buffer.remove(0);
			}
		}
		return index;
	}

}
