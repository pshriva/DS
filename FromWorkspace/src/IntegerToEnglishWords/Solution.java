package IntegerToEnglishWords;

//LCA
public class Solution {
	static String[] lessThanTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	static String[] lessThanTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
	static String[] lessThanHundred = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static void main(String args[]){
		int num = 523425197;
		String result = numberToWords(num);
		System.out.println(result);
	}
	
	private static String numberToWords(int num) {
		if(num == 0){return "Zero";}
		return getNumberInWords(num);
	}

	private static String getNumberInWords(int num) {
		String result = new String();
        if(num == 0){result = "";}
        else if(num < 10){result = lessThanTen[num];}
        else if(num < 20){result = lessThanTwenty[num%10];}
        else if(num < 100){result = lessThanHundred[num/10] + " " + lessThanTen[num%10];}
        else if(num < 1000){result = lessThanTen[num/100] + " Hundred " + getNumberInWords(num%100);}
        else if(num < 1000000){result = getNumberInWords(num/1000) + " Thousand " + getNumberInWords(num%1000);}
        else if(num < 1000000000){result = getNumberInWords(num/1000000) + " Million " + getNumberInWords(num%1000000);}
        else {result = getNumberInWords(num/1000000000) + " Billion " + getNumberInWords(num%1000000000);}
        return result.trim();
	}
}
