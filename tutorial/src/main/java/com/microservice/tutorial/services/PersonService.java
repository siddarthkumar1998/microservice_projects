package com.microservice.tutorial.services;

import java.util.List;

import com.microservice.tutorial.models.Person;

public interface PersonService {
	
	public List<Person> getAllPersons();
	
	public Person getPersonById(String id);

}
