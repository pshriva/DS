package BackspaceStringCompare;
//LCA
public class Solution {
	public static void main(String []args){
		String s = "ab##";
		String t = "c#d#";
		boolean isSame = compare(s, t);
		System.out.println(isSame);
	}

	private static boolean compare(String s, String t) {
		int i = s.length()-1;
		int j = t.length()-1;
		int skipS = 0;
		int skipT = 0;
		while(i >=0 || j >= 0){
			while(i >=0 && s.charAt(i) == '#'){
				i--;
				skipS++;
			}
			while(j >=0 && t.charAt(j) == '#'){
				j--;
				skipT++;
			}
			if(skipS >0){
				i--;
				skipS--;
				continue;
			}
			if(skipT > 0){
				j--;
				skipT--;
				continue;
			}
			if((i>=0 && j<0) || (j<=0 && i>0) || (s.charAt(i) != t.charAt(j))){return false;}
			else{
				i--;
				j--;
			}
		}
		return i<0 && j < 0;
	}
}
