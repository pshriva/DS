package Ctrx;

import java.util.*;

public class Solution1 {
	public static int minimumMoves(List<Integer> a, List<Integer> m) {
		int i = 0;
		int count = 0;
		while (i < a.size()) {
			int arr = a.get(i);
			int mrr = m.get(i);

			if (arr != mrr) {
				String arr_str = Integer.toString(arr);
				String mrr_str = Integer.toString(mrr);
				for (int k = 0; k < arr_str.length(); k++) {
					int a_num = arr_str.charAt(k) - '0';
					int m_num = mrr_str.charAt(k) - '0';
					count = count + Math.abs(a_num - m_num);
				}
			}
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> m = new ArrayList<Integer>();

		a.add(123);
		a.add(543);

		m.add(321);
		m.add(279);

		System.out.println(minimumMoves(a, m));
	}
	
	
	
}
