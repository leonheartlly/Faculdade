package org.unitri.ppi2.rest.dao;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Categoria;
import org.unitri.ppi2.rest.domain.Veiculo;

public class VeiculoDAO extends GenericDAO<Veiculo, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public VeiculoDAO(EntityManager entityManager){
		super(Veiculo.class, entityManager);
	}

	public List<Veiculo> findByPreco(Integer id) {

		Categoria categoria = entityManager.find(Categoria.class,id);
		
		List<Veiculo> veiculos = entityManager.createQuery("select vei from Veiculo vei,Categoria cat "
				+ "where cat.idCategoria=vei.categoria "
						+ "and cat.preco <="+categoria.getPreco(), Veiculo.class).getResultList();
		return veiculos;
	}

	
	
	
	
}
