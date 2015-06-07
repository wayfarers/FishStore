package org.genia.fishstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T>{

	@PersistenceContext
	EntityManager em;
	
	protected Class<T> entityClass;
	
	public GenericDaoImpl() {}
	
	public GenericDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Override
	public T findById(int id) {
		return em.find(entityClass, id);
	}

	@Override
	public void save(T entity) {
		if (hasEmptyId(entity)) {
			// Its a new
			em.persist(entity);
		} else {
			em.merge(entity);
		}
	}
	
	private boolean hasEmptyId(T entity) {
		try {
			// Use reflection to get an identifier
			return entity.getClass().getMethod("getId").invoke(entity) == null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void removeById(int id) {
		em.createQuery("delete from "  + entityClass.getSimpleName() + "where id = " + id).executeUpdate();
	}

//	@Override
//	public List<T> findAll() {
//		return em.createQuery("select entity from " + entityClass.getSimpleName() + " entity", entityClass).getResultList();
//	}
	

}
