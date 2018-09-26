package StaticAndNonStatic;

public class Student {
	static String city = "Sagar";
	String name;
	public Student(String name){
		this.name = name;
	}
	public static void changeCity(String newCity){
		city = newCity;
	}
}
