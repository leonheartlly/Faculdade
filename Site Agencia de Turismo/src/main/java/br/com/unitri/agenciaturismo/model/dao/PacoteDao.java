package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Pacote;

public interface PacoteDao extends GenericDao<Pacote, Integer>{

	
	List<Pacote> listAll();
	Pacote findByID(int id);
	Pacote findByName(String name);
	
	void addPacote(Pacote pacote);
	void updatePacote(Pacote pacote);
	void removePacote(Pacote pacote);

}
