package com.first.micro.currencyexchangeservice.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ExchangeValue {

	@Id
	Long id;
	
	@JsonProperty(value = "from")
	@Column(name = "currency_from")
	String source;
	
	@JsonProperty(value = "to")
	String target;
	
	int port;
	
	BigDecimal conversionMultiple;

	public ExchangeValue() {
		super();
	}

	public ExchangeValue(Long id, String source, String target, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.source = source;
		this.target = target;
		this.conversionMultiple = conversionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	

}
