package com.microservice.tutorial.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonFilter("PersonFilter")
@Entity
public class Person {

    @Id
    @GeneratedValue
	int rollNo;
	String name;
	int age;
	String city;
	@OneToMany(mappedBy = "person")
	List<Post> posts;
	
	public Person()
	{
		
	}
	
	public Person(int rollNo, String name, int age, String city) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.city = city;
	}	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}
