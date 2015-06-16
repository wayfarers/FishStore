package org.genia.fishstore.web;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
public class MessageBean {
	private final String fieldRequired = "This field could not be empty";
	private final String overWeight = "Weight entered is bigger than available on store";
	
	public String getFieldRequired() {
		return fieldRequired;
	}
	public String getOverWeight() {
		return overWeight;
	}
	
	
}

