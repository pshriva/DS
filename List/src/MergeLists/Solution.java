package MergeLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public static void main(String args[]) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(8,10));
		list.add(new Interval(1,3));
		list.add(new Interval(15,18));
		list.add(new Interval(2,6));
		List<Interval> result = mergeIntervals(list);
		for(Interval i : result) {
			System.out.println(i.first + " " + i.second);
		}
	}

	private static List<Interval> mergeIntervals(List<Interval> list) {
		if(list.size() <= 1) {return list;}
		List<Interval> result = new ArrayList<>();
		Collections.sort(list, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {return (a.first - b.first);}
		});
		int begin = list.get(0).first;
		int end = list.get(0).second;
		for(int i = 1; i<list.size(); i++) {
			if(end >=  list.get(i).first) {end = Math.max(end, list.get(i).second);}
			else {
				result.add(new Interval(begin, end));
				begin = list.get(i).first;
				end = list.get(i).second;
			}
		}
		result.add(new Interval(begin, end));
		return result;
	}
}
