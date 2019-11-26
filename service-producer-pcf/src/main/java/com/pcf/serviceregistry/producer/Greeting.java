package com.pcf.serviceregistry.producer;

public class Greeting {

	private static final String template = "%s, %s!";

	private String message;

	public Greeting(String salutation, String name) {
		this.message = String.format(template, salutation, name);
	}

	public String getMessage() {
		return this.message;
	}
}
