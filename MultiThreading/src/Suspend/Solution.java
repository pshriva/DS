package Suspend;
//https://www.geeksforgeeks.org/green-vs-native-threads-and-deprecated-methods-in-java/
public class Solution {
//MAKE SURE TO TERMINATE THIS PROGRAM FROM CONSOLE AS THE THREADS ARE IN SUSPENDED STATE SO PROGRAM DOES NOT STOP
	public static void main(String[] args) throws InterruptedException {
		Printer p = new Printer();
		CustomPrinter p1 = new CustomPrinter("PrimaryThread", p);
		CustomPrinter p2 = new CustomPrinter("SecondaryThread", p);
		p1.start();
		Thread.sleep(1000);
		p2.start();
		System.out.println("Both thread finished execution");
	}

}
