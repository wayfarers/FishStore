package org.genia.fishstore.services;

import java.io.IOException;

import javax.inject.Inject;

import org.genia.fishstore.dao.CompanyOrderDao;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-beans.xml"})
public class CompanyOrderDaoTest {

	@Inject
	TestSetupService testSetupService;
	
	@Inject
	CompanyOrderDao companyOrderDao;
	
//	@Test
//	public void getsAllAvailableItems() {
//		testSetupService.generateCompanyOrders(5);
//		List<CompanyOrderItem> results = companyOrderDao.getAvailableItems();
//		Assert.assertEquals(5, results.size());
//	}
	
	@Before
	public void prepareDb() throws IOException {
		testSetupService.deleteEverything();
	}
}
