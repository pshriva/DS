package Read4;

public class Solution {
	static Read4 r = new Read4("abcdefghijklmnopqrstuvwxyz");
//	static Read4 r = new Read4("abcde");
	public static void main(String[] args) {
		int n = 3;
		char[] buf = new char[3];
		int read = read(buf, n);
		System.out.println(read);
		for(char c : buf){System.out.print(c + " ");}
		System.out.println();
	}

//	private static int read(char[] buf, int n) {
//		int index = 0;
//		int left = n;
//		while(left > 0){
//			char[] temp = new char[4];
//			int count = r.read4(temp);//4
//			if(count == 0){break;}
//			for(int i = 0; i < Math.min(count, left); i++){
//				buf[index++] = temp[i];
//			}
//			left = left - count;
//		}
//		return index;
//	}
	private static int read(char[] buf, int n) {
		int index = 0;
		while(index < n){
			char[] temp = new char[4];
			int count = r.read4(temp);//4
			if(count == 0){break;}
			for(int i = 0; i < count && index < n; i++){
				buf[index++] = temp[i];
			}
		}
		return index;
	}

}
