package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Funcionario;
import br.com.unitri.agenciaturismo.model.dao.FuncionarioDao;
import br.com.unitri.agenciaturismo.service.FuncionarioService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	FuncionarioDao funcionarioDao;
	
	public List<Funcionario> listAll() {
		return funcionarioDao.listAll();
	}

	public Funcionario findByID(int id) {
		return funcionarioDao.findByID(id);
	}

	public Funcionario findByName(String name) {
		return funcionarioDao.findByName(name);
	}

	public void addFuncionario(Funcionario funcionario) {
		funcionarioDao.addFuncionario(funcionario);
	}

	public void updateFuncionario(Funcionario funcionario) {
		funcionarioDao.updateFuncionario(funcionario);
	}

	public void removeFuncionario(Funcionario funcionario) {
		funcionarioDao.removeFuncionario(funcionario);
	}
	
	

	
}
