package com.first.micro.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.micro.currencyexchangeservice.models.ExchangeValue;

@Repository
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue,Long>{
      
	ExchangeValue findBySourceAndTarget(String source , String target);
}
