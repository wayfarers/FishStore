package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.FishType;

public interface FishTypeDao extends GenericDao<FishType>{
	public List<String> getFishNames();
	public List<FishType> getFishList();
}
