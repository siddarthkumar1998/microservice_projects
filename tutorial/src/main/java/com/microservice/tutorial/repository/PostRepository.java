package com.microservice.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.tutorial.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{
	
}
