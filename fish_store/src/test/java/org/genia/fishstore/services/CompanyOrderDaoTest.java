package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.PurchaseOrderDao;
import org.genia.fishstore.entities.FishBatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-beans.xml"})
public class CompanyOrderDaoTest {

	@Inject
	TestSetupService testSetupService;
	
	@Inject
	PurchaseOrderDao companyOrderDao;
	
	@Test
	public void getsAllAvailableItems() {
//		testSetupService.generateCompanyOrders(5);
		List<FishBatch> results = companyOrderDao.getOrderItems(companyOrderDao.getOrders().get(0).getId());
//		Assert.assertEquals(5, results.size());
	}
//	
//	@Before
//	public void prepareDb() throws IOException {
//		testSetupService.deleteEverything();
//	}
	
}
