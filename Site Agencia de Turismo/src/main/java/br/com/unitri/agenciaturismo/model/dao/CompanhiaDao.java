package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Companhia;


public interface CompanhiaDao extends GenericDao<Companhia, Integer>{

	List<Companhia> listAll();
	Companhia findByID(int id);
	Companhia findByName(String name);
	
	void addCompanhia(Companhia companhia);
	void updateCompanhia(Companhia companhia);
	void removeCompanhia(Companhia companhia);
}
