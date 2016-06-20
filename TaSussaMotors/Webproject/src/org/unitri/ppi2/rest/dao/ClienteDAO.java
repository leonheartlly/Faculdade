package org.unitri.ppi2.rest.dao;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public ClienteDAO(EntityManager entityManager){
		super(Cliente.class, entityManager);
	}	
	
	public List<Cliente> pesquisarPorLocacaoPorMes(Integer mes) {
		List<Cliente> clientes = entityManager.createQuery("select cli from Cliente cli join cli.locacaos loc where MONTH(loc.data) = :mes", Cliente.class)
				.setParameter("mes", mes)
				.getResultList();
		return clientes;
	}
	
	
}
