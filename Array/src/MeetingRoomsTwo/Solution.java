package MeetingRoomsTwo;

import java.util.*;
import java.util.Comparator;

public class Solution {
	public static void main(String [] args) {
//		Interval[] intervals = new Interval[3];
//		intervals[0] = new Interval(0,6);
//		intervals[1] = new Interval(5,14);
//		intervals[2] = new Interval(15,20);
		Interval[] intervals = new Interval[8];
		intervals[0] = new Interval(1,2);
		intervals[1] = new Interval(1,4);
		intervals[2] = new Interval(3,5);
		intervals[3] = new Interval(7,15);
		intervals[4] = new Interval(7,8);
		intervals[5] = new Interval(9,10);
		intervals[6] = new Interval(11,15);
		intervals[7] = new Interval(16,17);
		int meetingRooms = getMinimumMeetingRooms(intervals);
		System.out.println(meetingRooms);
	}

	
//	Very wrong solution, its not considering the meeting room emptied by (1,2) to be used by (3,5)
//	But waiting for (1,4) to empty the room
//	private static int getMinimumMeetingRooms(Interval[] intervals) {
//		if(intervals.length == 0) {return 0;}
//		Arrays.sort(intervals, new Comparator<Interval>() {
//			public int compare(Interval a, Interval b) {return a.start - b.start;}
//		});
//		int meetingRooms = 0;
//		int end = intervals[0].end;
//		for(int i = 0; i< intervals.length - 1 ; i++) {
//			if(end >= intervals[i+1].start) {
//				meetingRooms++;
//				end = Math.max(end, intervals[i+1].end);
//			}else {
//				end = intervals[i+1].end;
//			}
//		}
//		return meetingRooms+1;
//	}
	
//	Using Priority Queue
//	private static int getMinimumMeetingRooms(Interval[] intervals) {
//		if(intervals.length == 0) {return 0;}
//		Arrays.sort(intervals, new Comparator<Interval>() {
//			public int compare(Interval a, Interval b) {return a.start - b.start;}
//		});
//		Queue<Integer> queue = new PriorityQueue<>();
//		queue.add(intervals[0].end);
//		for(int i = 1; i < intervals.length; i++){
//			if(intervals[i].start >= queue.peek()){
//				queue.remove();
//			}
//			queue.add(intervals[i].end);
//		}
//		return queue.size();
//	}
	
	
	
//	Without using Priority Queue, complexity is still same O(nlog) because of sorting the elements, but is better
//	private static int getMinimumMeetingRooms(Interval[] intervals) {
//		List<Point> list = new ArrayList<>(intervals.length*2);
//        for(Interval i : intervals){
//          list.add(new Point(i.start, 1));
//          list.add(new Point(i.end, 0));
//        }
//    
//        Collections.sort(list, new Comparator<Point>(){
//			@Override
//			public int compare(Point p1, Point p2) {
//				if(p1.time == p2.time){return p1.flag - p2.flag;}
//				return p1.time - p2.time;
//			}
//        });
//        int count = 0, ans = 0;
//        for(Point p : list){
//            if(p.flag == 1) {
//                count++;
//            }
//            else {
//                count--;
//            }
//            ans = Math.max(ans, count);
//        }
//    
//        return ans;
//	}


//	static class Point{
//	    int time;
//	    int flag;
//
//	   public Point(int t, int s){
//	      this.time = t;
//	      this.flag = s;
//	    }
//	}
	
	
//	Even wihtout using the point class
	private static int getMinimumMeetingRooms(Interval[] intervals) {
//		if(intervals.length == 0) {return 0;}
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++){
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int s = 0;
		int e = 0;
		int currRooms = 0;
		int maxRooms = 0;
		while(s < start.length || e < end.length){
			if(s >= start.length){break;}
			else if(start[s] < end[e]){
				currRooms++;
				s++;
			}else{
				currRooms--;
				e++;
			}
			maxRooms = Math.max(maxRooms, currRooms);
		}
		return maxRooms;
	}
}
