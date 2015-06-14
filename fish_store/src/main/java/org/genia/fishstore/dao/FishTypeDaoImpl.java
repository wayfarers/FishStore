package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.FishType;
import org.springframework.stereotype.Repository;

@Repository
public class FishTypeDaoImpl extends GenericDaoImpl<FishType> implements FishTypeDao{
	public FishTypeDaoImpl() {
		super(FishType.class);
	}
	
	@Override
	public List<String> getFishNames() {
		return em.createQuery("select ft.name from FishType ft", String.class).getResultList();
	}
	
	@Override
	public List<FishType> getFishList() {
		return em.createQuery("select ft from FishType ft", FishType.class).getResultList();
	}
}
