package StaticAndNonStatic;

public class Solution {
	public static void main(String [] args){
		Student s = new Student("Pranjali");
		System.out.println(s.name);
		System.out.println(s.city);
		Student s2 = new Student("Megha");
		System.out.println(s2.name);
		System.out.println(s2.city);
		s2.city = "San Jose";
		System.out.println(s2.city);
		System.out.println(s.city);
		s2.changeCity("Milpitas");
		System.out.println(s.city);
		
	}
}
