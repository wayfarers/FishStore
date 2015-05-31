package org.genia.fishstore.services;

import org.genia.fishstore.dao.GenericDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenericServiceImpl<T> implements GenericService<T> {

	protected GenericDao<T> dao;
    
    public GenericServiceImpl() { }

    public GenericServiceImpl(GenericDao<T> dao, Class<T> entityClass) {
        this.dao = dao;
    }
	
	@Override
	public T findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void save(T entity) {
		dao.save(entity);
	}
}
