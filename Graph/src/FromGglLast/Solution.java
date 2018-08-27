package FromGglLast;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

public class Solution {
	public static void main(String args[]) {
		int[] A = new int[] { 2, 2, 1, 1, 2, 1, 2, 3, 3, 3, 1, 1 };
		int[] E = new int[] { 1, 2, 1, 3, 2, 4, 2, 5, 3, 6, 4, 7, 4, 8, 5, 9, 5, 10, 6, 11, 11, 12 };
		int len = getMaxLength(A, E);
		System.out.println(len);
	}

	private static int getMaxLength(int[] a, int[] e) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int maxLength = 0;
		for (int i = 0; i < e.length; i += 2) {
			int label1 = a[e[i] - 1];
			int label2 = a[e[i + 1] - 1];
			if (label1 == label2) {
				if (map.containsKey(e[i])) {
					map.get(e[i]).add(e[i + 1]);
				} else {
					map.put(e[i], new ArrayList<Integer>(Arrays.asList(e[i + 1])));
				}
			}
		}

		for (int key : map.keySet()) {
			// System.out.println(key + " " + map.get(key));
			int len = getMaxLenAtKey(key, map);
			System.out.println("Max length at node " + key + " is " + len);
			maxLength = Math.max(len, maxLength);
		}
		return maxLength;

	}

	private static int getMaxLenAtKey(int key, Map<Integer, List<Integer>> map) {
		System.out.println("Key is ************* " + key);
		if (map.get(key) == null) {
			return 0;
		}
		if (map.get(key).size() == 1) {
			System.out.println("Left key " + map.get(key).get(0));
			return (getMaxAtNode(map.get(key).get(0), map) + 1);
		} else {
			System.out.println("Left key " + map.get(key).get(0));
			System.out.println("Right key " + map.get(key).get(1));
			return ((getMaxAtNode(map.get(key).get(0), map) +
					getMaxAtNode(map.get(key).get(1), map)) + 2);
		}
	}

	private static int getMaxAtNode(int key, Map<Integer, List<Integer>> map) {
		System.out.println("Inside recursion function ");
		if (map.get(key) == null) {
			return 0;
		}
		if (map.get(key).size() == 1) {
			System.out.println("Inside if");
			System.out.println("left child " + map.get(key).get(0));
			int len = getMaxAtNode(map.get(key).get(0), map) + 1;
			System.out.println("Returning " + len);
			return (len);
		} else {
			System.out.println("inside else");
			System.out.println("Left child " + map.get(key).get(0));
			System.out.println("Right child " + map.get(key).get(1));
			int len = Math.max(getMaxAtNode(map.get(key).get(0), map),
							  getMaxAtNode(map.get(key).get(1), map)) + 1;
			System.out.println("Returning len" + len);
			return len;

			// return Math.max(getMaxAtNode(map.get(key).get(0), map),
			// getMaxAtNode(map.get(key).get(1), map)) + 1;

		}

	}

}
