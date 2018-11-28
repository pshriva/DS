package ExcelSheetColumnTitleAndColumnNumber;
//LCA
public class Solution {
	public static void main(String[] args){
		int num = 52;
		String column = getColumnName(num);
		System.out.println(column);
		int colNumber = getColumnNumber("AZ");
		System.out.println(colNumber);
	}

	private static int getColumnNumber(String s) {
		int num = 0;
        int count = s.length()-1;
        int base = 1;
        while(count >= 0){
            num = (s.charAt(count) - 'A' + 1)*base + num;
            base = base*26;
            count--;
        }
		return num;
	}

	private static String getColumnName(int num) {
		String result = "";
		while(num > 0){
			num--;
			result = (char)(num%26 + 'A') + result;
			num = num/26;
		}
		return result;
	}
}
