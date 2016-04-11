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
		
		List<Avaria> avarias = entityManager.createQuery("select ava from Avaria ava, Locacao loca "
				+ "where loca. "
						+ "and loca.idLocacao ="+locacao.getIdLocacao(), Avaria.class).getResultList();
	
//		TODO verificar como fazer o select abaixo com o framework
		
//		select ava.descricao from locacao.avaria ava, locacao.locacao_avaria loca, locacao.locacao lolo
//			where loca.idLocacao = loca.idAvaria 
//				and lolo.idLocacao =1;
		
		return avarias;
	}	
	
	
	
	
}
