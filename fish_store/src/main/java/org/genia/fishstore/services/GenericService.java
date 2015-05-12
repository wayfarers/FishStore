package org.genia.fishstore.services;

import java.util.List;

public interface GenericService<T> {
	public T findById(int id);
	public void save(T entity);
	public List<T> findAll();
}
