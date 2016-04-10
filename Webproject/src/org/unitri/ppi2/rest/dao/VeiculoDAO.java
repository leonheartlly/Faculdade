package org.unitri.ppi2.rest.dao;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Veiculo;

public class VeiculoDAO extends GenericDAO<Veiculo, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public VeiculoDAO(EntityManager entityManager){
		super(Veiculo.class, entityManager);
	}	
	
	
	
	
}
