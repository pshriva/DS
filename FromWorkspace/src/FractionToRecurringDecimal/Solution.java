package FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;
// 0.012012012 => 0.(012), 0.003 => 0.003, 0.6666666 => 0.(6), 0.25 => 0.25
public class Solution {
	public static void main(String[] args){
		int num = 0;
		int den = -5;
//		System.out.println((float)num/den);
		String result = getResult(num, den);
		System.out.println("Result :");
		System.out.println(result);
	}

	private static String getResult(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
		sb.append(sign);
		int num = Math.abs(numerator);
		int den = Math.abs(denominator);
		sb.append(num/den);
		if(num%den == 0){return sb.toString();}
		sb.append(".");
		Map<Integer, Integer> map = new HashMap<>();
		int remainder = num%den;
		while(!map.containsKey(remainder)){
			map.put(remainder, sb.length());
			sb.append(remainder*10/den);
			remainder = remainder*10%den;
		}
		int index = map.get(remainder);
		sb.insert(index, "(");
		sb.append(")");
		
		return sb.toString().replace("(0)", "");
	}
}
