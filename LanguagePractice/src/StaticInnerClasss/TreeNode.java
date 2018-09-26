package StaticInnerClasss;

public class TreeNode {
	public static String name = "Tree";
	public static class Node{
		public static String name = "InnerTree";
		public void printName(){
			System.out.println(name);
			System.out.println(TreeNode.name);
		}
		public static void printNameStatic(){
			System.out.println("Static inner method");
		}
	}
	public static void printName() {
		// TODO Auto-generated method stub
		System.out.println(name);
	}
	public void printnameNonStatic(){
		System.out.println("Non-static method");
		Node.printNameStatic();
	}
}
