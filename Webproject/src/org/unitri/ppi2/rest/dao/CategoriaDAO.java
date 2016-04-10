package org.unitri.ppi2.rest.dao;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public CategoriaDAO(EntityManager entityManager){
		super(Categoria.class, entityManager);
	}	
	
	
	
	
}
