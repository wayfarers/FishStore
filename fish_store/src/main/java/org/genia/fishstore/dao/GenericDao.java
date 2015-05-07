package org.genia.fishstore.dao;


public interface GenericDao <T> {
	public T findById(int id);
	public void save(T entity);
	public void update(T entity);
	
	
}
