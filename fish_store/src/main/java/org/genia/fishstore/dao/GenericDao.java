package org.genia.fishstore.dao;



public interface GenericDao <T> {
	public T findById(int id);
	public void save(T entity);
	public void removeById(int id); 
	
	// TODO: Implement a generic findAll(@Nullable PageInfo pageInfo);
//	public List<T> findAll();
	
	//public void update(T entity);
	
	
}
