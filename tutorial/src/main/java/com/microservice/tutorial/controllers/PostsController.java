package com.microservice.tutorial.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.tutorial.models.Person;
import com.microservice.tutorial.models.Post;
import com.microservice.tutorial.repository.PersonRepository;
import com.microservice.tutorial.repository.PostRepository;

import io.swagger.models.HttpMethod;

@Controller
@RequestMapping(value = "/posts")
public class PostsController {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	
	@RequestMapping(value = "/post/{id}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Post> getPostById(@PathVariable String id)
	{
	   return ResponseEntity.of(Optional.of(postRepository.findById(Integer.valueOf(id)).get()));
	}
	
	@RequestMapping(value = "/allPosts",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Post>> getPosts()
	{
	   return ResponseEntity.of(Optional.of(postRepository.findAll()));
	}
	
	@RequestMapping(value = "/{id}/addPost",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> getPosts(@PathVariable int id ,@RequestBody @Validated Post post)
	{
		Person p = personRepository.findById(id).get();
		post.setPerson(p);
		postRepository.save(post);
	   return ResponseEntity.of(Optional.of(Boolean.TRUE));
	}
	

}
