package Read4;

public class Read4 {
	String s;
	int pointer;
	public Read4(String s){
		this.s = s;
		pointer = 0;
	}
	public int read4(char[] temp) {
		int count = 0;
		for(int i = 0; i< 4 && pointer < s.length(); i++){
			temp[i] = s.charAt(pointer++);
			count++;
		}
		return count;
	}
}
