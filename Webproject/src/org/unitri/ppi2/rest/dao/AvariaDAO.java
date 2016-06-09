package org.unitri.ppi2.rest.dao;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Avaria;
import org.unitri.ppi2.rest.domain.Locacao;

public class AvariaDAO extends GenericDAO<Avaria, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public AvariaDAO(EntityManager entityManager){
		super(Avaria.class, entityManager);
	}

	public List<Avaria> findByLocacao(Integer id) {
		
		Locacao locacao = entityManager.find(Locacao.class,id);
		
		if(locacao == null){
			return null;
		}
		
		return locacao.getAvarias();
	}	
	
	
	
	
}
