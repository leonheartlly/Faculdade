package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Funcionario;

public interface FuncionarioDao extends GenericDao<Funcionario, Integer>{

	
	List<Funcionario> listAll();
	Funcionario findByID(int id);
	Funcionario findByName(String name);
	
	void addFuncionario(Funcionario funcionario);
	void updateFuncionario(Funcionario funcionario);
	void removeFuncionario(Funcionario funcionario);

}
