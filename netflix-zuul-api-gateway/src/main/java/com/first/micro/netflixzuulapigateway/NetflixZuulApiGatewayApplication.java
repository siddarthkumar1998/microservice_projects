package com.first.micro.netflixzuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class NetflixZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayApplication.class, args);
	}
	
	@Bean
	public ZuulLoggingFilter getRouteFilter()
	{
		return new ZuulLoggingFilter();
	}
	
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}
	

}
