package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.FishType;

public interface FishTypeService extends GenericService<FishType> {
	public List<String> getFishNames();
	public List<FishType> getFishList();
}
