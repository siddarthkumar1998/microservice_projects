package com.microservice.tutorial.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.microservice.tutorial.models.Person;
import com.microservice.tutorial.services.PersonService;

@Component
public class DefaultPersonService implements PersonService  {

	static List<Person> pList = new ArrayList<>();
	
	static {
		pList.add(new Person(0,"Adil",22,"Agra"));
		pList.add(new Person(1,"Siddarth",22,"Hyderabad"));
		pList.add(new Person(2,"Afreen",22,"Bihar"));
		pList.add(new Person(3,"Upasna",22,"Maharashtra"));
		pList.add(new Person(4,"Maina",22,"Tamil Nadu"));
		pList.add(new Person(5,"Batham",22,"Bhopal"));
		pList.add(new Person(6,"Jappan",22,"Nagpur"));
		
	}
	
	@Override
	public List<Person> getAllPersons() {
		return pList;
	}

	@Override
	public Person getPersonById(String id) {
		
		return pList.stream().filter(person->person.getRollNo()==Integer.valueOf(id)).collect(Collectors.toList()).get(0);
	}

}
