package com.first.micro.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.first.micro.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.first.micro.currencyconversionservice.models.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);
	
	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeervice;
	
	@GetMapping(value="/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConversion(@PathVariable String from ,@PathVariable String to,@PathVariable String quantity)
	{
		/*Map<String,String> hashmap= new HashMap();
		hashmap.put("from", from);
		hashmap.put("to", to);
	     ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,hashmap);	*/
		CurrencyConversionBean response = currencyExchangeervice.retreibeConversionDetails(from, to);
		System.setProperty("localhost", "proxyServer.proxy.com");
		System.setProperty("proxyPort", "9801");
		log.info("{}",response.getPort());
		return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),BigDecimal.valueOf(Double.valueOf(quantity)),BigDecimal.valueOf(Double.valueOf(quantity)).multiply(response.getConversionMultiple()),response.getPort());
	}

}
