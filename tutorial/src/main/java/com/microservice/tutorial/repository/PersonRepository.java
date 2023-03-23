package com.microservice.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.tutorial.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
