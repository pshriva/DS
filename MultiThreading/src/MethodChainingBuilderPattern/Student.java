package MethodChainingBuilderPattern;

public class Student {
	int id;
	String name;
	String address;
	public Student(Builder builder) {
		this.id = builder.id;
	}
	public Student(){}
	public static class Builder{
		int id;
		String name;
		String address;
		public static Builder newInstance(){
			return new Builder();
		}
		public Builder setId(int id){
			this.id = id;
			return this;
		}
		public Builder setName(String name){
			this.name = name;
			return this;
		}
		public Builder setAddress(String address){
			this.address = address;
			return this;
		}
		public Student build(){
			return new Student(this);
		}
	}
	public String toString(){
		return "id = " + this.id + ", name = " + this.name + ", address = " + this.address; 
	}
}
