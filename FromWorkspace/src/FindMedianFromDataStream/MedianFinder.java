package FindMedianFromDataStream;

import java.util.*;

public class MedianFinder {
		Queue<Integer> min;
		Queue<Integer> max;
		public MedianFinder(){
			min = new PriorityQueue<>();
			max = new PriorityQueue<>((a, b) -> (b-a));
		}
		
		
		public void addNum(int num) {
			if(max.size() == 0){
				max.offer(num);
			}else{
				if(num <= max.peek()){
					max.offer(num);
				}else{
					min.offer(num);
				}
			}
			
			if(max.size() > min.size() + 1){
				min.offer(max.poll());
			}else if(min.size() > max.size()){
				max.offer(min.poll());
			}
		}
	
	
		public double findMedian() {
			return (max.size() == min.size()) ? 0.5 * (min.peek() + max.peek()) : max.peek();
		}
}
