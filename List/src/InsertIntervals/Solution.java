package InsertIntervals;
//LCA
import java.util.*;

public class Solution {

	
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		
//		Case to justify taking right = intervals.length()  and not intervals.length()-1
//		intervals.add(new Interval(1,5));
//		Interval newInterval = new Interval(2,3);
		
		intervals.add(new Interval(0,0));
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(6,8));
		intervals.add(new Interval(9,11));
		Interval newInterval = new Interval(0,9);
//		intervals.add(new Interval(1,3));
//		intervals.add(new Interval(6,9));
//		Interval newInterval = new Interval(2,5);
		List<Interval> mergedList = insertInterval(intervals, newInterval);
		for(Interval i : mergedList){
			System.out.println(i.start + " " + i.end);
		}
	}

	private static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
		int left = 0;
		int right = intervals.size();
		int start = newInterval.start;
		int end = newInterval.end;
		while(left < right){
			int mid = (left + right)/2;
			if(start <= intervals.get(mid).end){
				right = mid;
			}else{left = mid+1;}
		}
		int sIndex = left;
		left = 0;
		right = intervals.size();
		while(left < right){
			int mid = (left + right)/2;
			if(end >= intervals.get(mid).start){
				left = mid+1;
			}else{right = mid;}
		}
		int eIndex = left;
		if(sIndex != eIndex){
			start = Math.min(start, intervals.get(sIndex).start);
			end = Math.max(end, intervals.get(eIndex-1).end);
			intervals.add(sIndex, new Interval(start, end));
			for(int i = sIndex + 1; i<= eIndex; i++){
				intervals.remove(sIndex + 1); // cannot say i, bcz after each remove, the i already decreases by 1
			}
		}else{
			intervals.add(sIndex, new Interval(start, end));
		}
		return intervals;
	}
	

}
