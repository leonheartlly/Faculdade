package br.com.unitri.agenciaturismo.service;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Companhia;

public interface CompanhiaService {

	List<Companhia> listAll();
	Companhia findByID(int id);
	Companhia findByName(String name);
	
	void addCompanhia(Companhia companhia);
	void updateCompanhia(Companhia companhia);
	void removeCompanhia(Companhia companhia);
}
