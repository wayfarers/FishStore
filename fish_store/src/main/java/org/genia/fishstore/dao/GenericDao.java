package org.genia.fishstore.dao;

import java.util.List;


public interface GenericDao <T> {
	public T findById(int id);
	public void save(T entity);
	public void removeById(int id); 
	public List<T> findAll();
	//public void update(T entity);
	
	
}
