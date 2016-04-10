package org.unitri.ppi2.rest.dao;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Avaria;

public class AvariaDAO extends GenericDAO<Avaria, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public AvariaDAO(EntityManager entityManager){
		super(Avaria.class, entityManager);
	}	
	
	
	
	
}
