package org.unitri.ppi2.rest.dao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Funcionario;
import org.unitri.ppi2.rest.domain.Locacao;
import org.unitri.ppi2.rest.domain.Veiculo;


public class LocacaoDAO extends GenericDAO<Locacao, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public LocacaoDAO(EntityManager entityManager){
		super(Locacao.class, entityManager);
	}	
	
	public List<Locacao> pesquisarPorFuncionario(Integer id) {
		Funcionario funcionario = entityManager.find(Funcionario.class, id);
		List<Locacao> locacao = entityManager.createQuery("select loc from Locacao loc", Locacao.class).getResultList();
		List<Locacao> locacaoRest = new ArrayList<>();
		for(Locacao l: locacao){
			if(l.getFuncionario1().getIdfuncionario() == funcionario.getIdfuncionario()){
				locacaoRest.add(l);
			}
		}
		return locacaoRest;
	}

	public List<Locacao> pesquisarPorVeiculo(Integer id) {
		Veiculo veiculo = entityManager.find(Veiculo.class, id);
		List<Locacao> locacao = entityManager.createQuery("select loc from Locacao loc", Locacao.class).getResultList();
		List<Locacao> locacaoRest = new ArrayList<>();
		for(Locacao l: locacao){
			if(l.getVeiculo().getIdVeiculo() == veiculo.getIdVeiculo()){
				locacaoRest.add(l);
			}
		}
		return locacaoRest;
	}

	public List<Locacao> pesquisarPorMes(Integer mes) {
		List<Locacao> locacao = entityManager.createQuery("select loc from Locacao loc where MONTH(loc.data) = :mes", Locacao.class)
				.setParameter("mes", mes)
				.getResultList();
		return locacao;
	}
	
	
}
