package org.unitri.ppi2.rest.dao;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Locacao;

public class LocacaoDAO extends GenericDAO<Locacao, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public LocacaoDAO(EntityManager entityManager){
		super(Locacao.class, entityManager);
	}	
	
	
	
	
}
