package Base7;
//LCA
public class Solution {

	public static void main(String[] args) {
		int num = -7;
		String result = getBaseSeven(num);
		System.out.println(result);
	}

	private static String getBaseSeven(int num) {
		StringBuilder sb = new StringBuilder();
		String sign = num < 0 ? "-" : "";
		num = Math.abs(num);
		while(num >= 7){
			sb.append(num%7);
			num = num/7;
		}
		sb.append(num);
		return sign + sb.reverse().toString();
	}

}
