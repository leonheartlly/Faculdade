package br.com.unitri.agenciaturismo.service;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Cliente;

public interface ClienteService {

	List<Cliente> listAll();
	Cliente findByID(int id);
	Cliente findByName(String name);
	
	void addPessoa(Cliente pessoa);
	void updatePessoa(Cliente pessoa);
	void removePessoa(Cliente pessoa);
}
