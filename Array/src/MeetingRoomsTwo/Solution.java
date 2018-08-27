package MeetingRoomsTwo;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String [] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0,6);
		intervals[1] = new Interval(5,14);
		intervals[2] = new Interval(15,20);
		int meetingRooms = getMinimumMeetingRooms(intervals);
		System.out.println(meetingRooms);
	}

	private static int getMinimumMeetingRooms(Interval[] intervals) {
		if(intervals.length == 0) {return 0;}
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {return a.start - b.start;}
		});
		int meetingRooms = 0;
		int end = intervals[0].end;
		for(int i = 0; i< intervals.length - 1 ; i++) {
			if(end >= intervals[i+1].start) {
				meetingRooms++;
				end = Math.max(end, intervals[i+1].end);
			}else {
				end = intervals[i+1].end;
			}
		}
		return meetingRooms+1;
	}
}
