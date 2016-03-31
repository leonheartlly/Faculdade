package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Cliente;

public interface ClienteDao{
	
	List<Cliente> listAll();
	Cliente findByID(int id);
	Cliente findByName(String name);
	
	void addPessoa(Cliente pessoa);
	void updatePessoa(Cliente pessoa);
	void removePessoa(Cliente pessoa);

}
