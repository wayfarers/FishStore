package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.PurchaseOrderDao;
import org.genia.fishstore.entities.PurchaseOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseOrderServiceImpl extends GenericServiceImpl<PurchaseOrder> implements PurchaseOrderService {

	private PurchaseOrderDao dao;
	
	@Inject
	public PurchaseOrderServiceImpl(PurchaseOrderDao dao) {
		super(dao, PurchaseOrder.class);
		this.dao = dao;
	}
	
	@Override
	public PurchaseOrder findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void save(PurchaseOrder entity) {
		dao.save(entity);
	}

	@Override
	public List<PurchaseOrder> findAll() {
		return dao.getOrders();
	}

}
