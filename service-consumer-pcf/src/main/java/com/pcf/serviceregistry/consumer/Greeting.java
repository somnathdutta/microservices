package com.pcf.serviceregistry.consumer;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting implements Serializable{

	 /*private final String message;

	    @JsonCreator
	    public Greeting(@JsonProperty("message") String message) {
	        this.message = message;
	    }

	    public String getMessage() {
	        return this.message;
	    }*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public Greeting() {
	
	}

	public String getMessage() {
		return message;
	}

}
