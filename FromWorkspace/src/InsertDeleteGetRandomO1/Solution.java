package InsertDeleteGetRandomO1;

import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();
		rs.insert(1);
		rs.remove(2);
		rs.insert(2);
		System.out.println(rs.getRandom());
		rs.remove(1);
		rs.insert(2);
		System.out.println(rs.getRandom());
	}

}
