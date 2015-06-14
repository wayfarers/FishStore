package org.genia.fishstore.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.FishBatch;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
 
@Named(value = "dfView")
@Scope("session")
public class DFView implements Serializable {
	
	@Inject
	ShoppingCartBean cart;
	
	private String text = "aaa";
         
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private static final long serialVersionUID = 1L;

	// TODO: Configure verbose JSF logging
	// http://stackoverflow.com/questions/7363704/jsf2-logs-with-tomcat
	// This is required to understand whats going on behind...
	public void addToCart(FishBatch fishbatch) {
		System.out.println("method invoked");
    	//cart.setFishBatchSelected(fishbatch);
//    	Map<String, Object> options = new HashMap<String, Object>();
//    	options.put("contentHeight", 80);
//    	options.put("contentWidth", 400);
//        RequestContext.getCurrentInstance().openDialog("addToCart", options, null);
    }
     
}
