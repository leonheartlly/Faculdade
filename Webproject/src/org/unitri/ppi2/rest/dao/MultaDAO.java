package org.unitri.ppi2.rest.dao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Locacao;
import org.unitri.ppi2.rest.domain.Multa;

public class MultaDAO extends GenericDAO<Multa, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public MultaDAO(EntityManager entityManager){
		super(Multa.class, entityManager);
	}

	public List<Multa> findByLocacao(Integer id) {
		Locacao locacao = entityManager.find(Locacao.class, id);
		
		List<Multa> multas = entityManager.createQuery("select moo from Multa moo", Multa.class).getResultList();
		List<Multa> multasRet = new ArrayList<Multa>();
		for(Multa m : multas){
			for(Locacao loc : m.getLocacaos()){
				if(loc.getIdLocacao() == locacao.getIdLocacao()){
					multasRet.add(m);
				}
			}
		}
		
		return multasRet;
	}

	
	
	
}
