package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Cliente;
import br.com.unitri.agenciaturismo.model.dao.ClienteDao;
import br.com.unitri.agenciaturismo.service.ClienteService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteDao dao;

	public List<Cliente> listAll() {
		return dao.listAll();
	}

	public Cliente findByID(int id) {
		return dao.findByID(id);
	}

	public Cliente findByName(String name) {
		return dao.findByName(name);
	}

	public void addPessoa(Cliente pessoa) {
		dao.addPessoa(pessoa);
	}

	public void updatePessoa(Cliente pessoa) {
		dao.updatePessoa(pessoa);
	}

	public void removePessoa(Cliente pessoa) {
		dao.removePessoa(pessoa);
	}

}
