package FindMedianFromDataStream;

public class Solution {

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(10);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		System.out.println(mf.findMedian());
		mf.addNum(0);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(0);
		System.out.println(mf.findMedian());
		mf.addNum(0);
		System.out.println(mf.findMedian());
	}

}
