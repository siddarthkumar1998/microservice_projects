package com.microservice.tutorial.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.microservice.tutorial.models.Person;
import com.microservice.tutorial.models.Post;
import com.microservice.tutorial.repository.PersonRepository;

@Controller
@RequestMapping(method = RequestMethod.GET ,  value = "/welcomejpa")
public class HelloWorldJpaController {
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	PersonRepository personRepository;
	
	
	@RequestMapping(method = RequestMethod.GET ,  value = "/jpa/greet")
	@ResponseBody
	public ResponseEntity<String> greet()
	{
		return new ResponseEntity(HttpStatus.OK).of(Optional.of("Hello user"));
	}

	@RequestMapping(method = RequestMethod.GET ,  value = "/jpa/greetingsInternational")
	@ResponseBody
	public String greetingsInternationalized()
	{  Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.mesasage",null,"", locale);
	}
	
	@RequestMapping(method = RequestMethod.GET ,  value = "/jpa/allPersons")
	@ResponseBody
	public List<Person> getPersons()
	{
		return personRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET ,  value = "/jpa/allPersons/{id}")
	@ResponseBody
	public Person getPersonById(@PathVariable String id)
	{
		return personRepository.findById(Integer.valueOf(id)).get();
	}
	
	@RequestMapping(method = RequestMethod.GET ,  value = "/jpa/allPersons/hat/{id}")
	@ResponseBody
	public EntityModel getPersonByIdWithHateos(@PathVariable String id)
	{
		EntityModel model = EntityModel.of(personRepository.findById(Integer.valueOf(id)).get());
		WebMvcLinkBuilder builder =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPersons());
		WebMvcLinkBuilder builder1 =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).greet());
		model.add(builder.withRel("All-Persons"));
		model.add(builder1.withRel("Greet"));
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET ,  value = "/jpa/allPersons/filter/{id}")
	@ResponseBody
	public MappingJacksonValue getPersonByIdDynamicFiltering(@PathVariable String id)
	{
		MappingJacksonValue majava = new MappingJacksonValue(personRepository.findById(Integer.valueOf(id)).get());
		SimpleBeanPropertyFilter spf = SimpleBeanPropertyFilter.filterOutAllExcept("name","age");
		FilterProvider fp = new SimpleFilterProvider().addFilter("PersonFilter", spf);
		majava.setFilters(fp);
		return majava;
	}
	
	@RequestMapping(method = RequestMethod.GET ,  value = "/jpa/allPersons/posts/{id}")
	@ResponseBody
	public List<Post> getPersonsPostsByPersonId(@PathVariable String id)
	{
		return personRepository.findById(Integer.valueOf(id)).get().getPosts();
	}
	
	
}
