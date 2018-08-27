package MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0,4);
		intervals[1] = new Interval(5,10);
		intervals[2] = new Interval(15,20);
		boolean canAttendAll = canAttendAllMeetings(intervals);
		System.out.println(canAttendAll);
	}

	private static boolean canAttendAllMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {return a.start - b.start;}
		});
		for(int i = 0; i< intervals.length - 1; i++) {
			if(intervals[i].end > intervals[i+1].start) {return false;}
		}
		return true;
	}

}
