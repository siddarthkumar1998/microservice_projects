package com.first.micro.currencyconversionservice;

public class Employee {

	String name;
	int age;
	int rollnumber;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, int rollnumber) {
		super();
		this.name = name;
		this.age = age;
		this.rollnumber = rollnumber;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", rollnumber=" + rollnumber + "]";
	}
	
	
	
	
}
