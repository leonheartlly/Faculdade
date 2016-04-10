package org.unitri.ppi2.rest.dao;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public FuncionarioDAO(EntityManager entityManager){
		super(Funcionario.class, entityManager);
	}	
	
	
	
	
}
