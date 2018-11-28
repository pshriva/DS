package Runnable;

import java.io.FileNotFoundException;

public class MyRunnable implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is executing");
//		Checked exceptions cannot be thrown in the Runnable class, they must be handled here.
		try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		run time exception can be thrown
		throw new NullPointerException();
	}

}
