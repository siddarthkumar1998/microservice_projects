package com.first.micro.currencyexchangeservice.controllers;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.first.micro.currencyexchangeservice.models.ExchangeValue;
import com.first.micro.currencyexchangeservice.repository.ExchangeValueRepo;

@RestController
public class CurrencyExchengeController {

	Logger log = LoggerFactory.getLogger(CurrencyExchengeController.class);
	@Autowired
	ExchangeValueRepo repo;

	@Autowired
	Environment environment;

	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchangeCurrency(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repo.findBySourceAndTarget(from, to);
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		log.info("{}",Integer.valueOf(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

}
