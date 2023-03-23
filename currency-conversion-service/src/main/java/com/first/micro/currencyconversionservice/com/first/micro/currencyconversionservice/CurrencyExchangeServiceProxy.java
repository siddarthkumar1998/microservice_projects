package com.first.micro.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.first.micro.currencyconversionservice.models.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange-service" , url = "localhost:8000") //for ribbon url is not required
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway",url = "localhost:8765")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping(value="/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retreibeConversionDetails(@PathVariable("from") String from ,@PathVariable("to") String to);
	
}
