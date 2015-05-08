package org.genia.fishstore.services;

public interface GenericService<T> {
	public T findById(int id);
	public void save(T entity);
}
