package org.unitri.ppi2.rest.dao;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericDAO<T, K> implements DAO<T, K>  {
	
	private Class<T> entityClass;
	protected EntityManager entityManager;

	public GenericDAO(Class<T> entityClass, EntityManager entityManger) {
		this.entityClass = entityClass;
		this.entityManager = entityManger;
	}

	public void insert(T entity) {
		entityManager.persist(entity);
	}
	
	public void insertAll(List<T> entities) {
		for (T t : entities) {
			entityManager.persist(t);
		}	
	}

	public void remove(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	public void removeById(K id) {
		T entity = entityManager.find(entityClass, id);
		entityManager.remove(entity);	
	}

	public void update(T entity) {
		entityManager.merge(entity);	
	}
	
	public T findById(K id) {
		return entityManager.find(entityClass, id);
	}
	
	public List<T> listAll(){
		return entityManager.createQuery("select t from " + entityClass.getSimpleName() + " t", entityClass).getResultList();
	}
}
