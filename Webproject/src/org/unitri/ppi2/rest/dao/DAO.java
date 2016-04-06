package org.unitri.ppi2.rest.dao;

import java.util.List;

public interface DAO <T, K> {

	void insert(T entity);
	
	void insertAll(List<T> entity);

	void remove(T entity);

	void removeById(K id);

	void update(T entity);
	
	T findById(K id);
	
	List<T> listAll();

}
