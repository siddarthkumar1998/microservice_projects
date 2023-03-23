package com.first.micro.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.micro.limitsservice.Configuration;
import com.first.micro.limitsservice.models.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping(value = "limits")
	public LimitConfiguration getLimitCnfigurations()
	{
		 return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}

	@GetMapping(value = "fault")
	@HystrixCommand(fallbackMethod = "faultTolerated")
	public LimitConfiguration fault() throws Exception
	{
		throw new Exception("Hello Buddy");
	}
	
	public LimitConfiguration faultTolerated()
	{
		return new LimitConfiguration(9,9999);
	}
	
	
}
