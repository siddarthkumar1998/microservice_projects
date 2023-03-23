package com.first.micro.limitsservice.models;

public class LimitConfiguration {
     
	 private int minimum;
     private int maximum;
     
	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
     
     
}

