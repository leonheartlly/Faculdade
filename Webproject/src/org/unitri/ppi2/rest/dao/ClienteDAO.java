package org.unitri.ppi2.rest.dao;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public ClienteDAO(EntityManager entityManager){
		super(Cliente.class, entityManager);
	}	
	
	
	
	
}
