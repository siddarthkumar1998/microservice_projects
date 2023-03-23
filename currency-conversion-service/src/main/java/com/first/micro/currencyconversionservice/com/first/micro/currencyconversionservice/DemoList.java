package com.first.micro.currencyconversionservice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoList {

	public static void main(String[] args)
	{
		Employee e = new Employee("Sid",28,1);
		Employee f = new Employee("Bat",28,2);
		Employee g = new Employee("Jap",28,3);
		Employee h = new Employee("Upa",28,4);
		Employee i = new Employee("Ayu",28,5);
		
		List<Employee> employeeList = Arrays.asList(e,f,g,h,i);
		
	    List<String> stringList = Arrays.asList("Hello","MyName","Sid","Batham","Roshan","Ramore");
	    
	    stringList= stringList.stream().filter(string -> string.startsWith("R")).collect(Collectors.toList());
	    
	   // employeeList= employeeList.stream().filter(employee->employee.getAge()>26).collect(Collectors.toList());
	    
	    stringList = employeeList.stream().filter(employee->employee.getName().contains("a")).map(Employee::getName).collect(Collectors.toList());
	   
	    stringList = employeeList.stream().map(employe->employe.getName()).filter(employee->employee.contains("a")).collect(Collectors.toList());
		 List <Integer> ageList =  employeeList.stream().filter(employe->employe.getRollnumber()>2 && employe.getRollnumber()<5).map(employe->employe.getAge()).collect(Collectors.toList());
	    int sum = employeeList.stream().filter(employe->employe.getRollnumber()>2 && employe.getRollnumber()<5).map(employe->employe.getAge()).reduce((a,b)->a+b).get();
	    boolean anyMatch =  employeeList.stream().allMatch(employee->employee.getAge()==28);
	    System.out.println(anyMatch);
	
	    employeeList.forEach(employee->{
	    	
	    	employee.setName("Batham");
	     System.out.print(employee.getName());	    
	    });
	    
	    
	    
	}
	
}
