package org.genia.fishstore.services;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.genia.fishstore.entities.PurchaseOrder;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.FishType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

@Service
public class TestSetupService {
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void setupBasicDb() throws IOException {
		String sqlScript = StreamUtils.copyToString(
				this.getClass().getClassLoader().getResourceAsStream("setup-test-bd.sql"), 
				Charset.defaultCharset());
		String[] sqlLines = sqlScript.split("[\r\n]+");
		
		for (String sqlLine : sqlLines) {
			em.createNativeQuery(sqlLine).executeUpdate();
		}
	}
	
	private void createFishType(String name) {
		FishType fish = new FishType();
		fish.setName(name);
		em.persist(fish);
	}
	
	public void deleteEverything() {
		
	}
	
	@Transactional
	public void generateCompanyOrders(int orderNum) {
		// ...
		for (int i = 0; i < orderNum; i++) {
			PurchaseOrder order = new PurchaseOrder();
			// ..
			em.persist(order);
		}
	}
} 

/**
 * a+
 * [a-z]+
 * [\r\n]+ 
*/