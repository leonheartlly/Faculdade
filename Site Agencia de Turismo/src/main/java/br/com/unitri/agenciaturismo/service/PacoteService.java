package br.com.unitri.agenciaturismo.service;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Pacote;

public interface PacoteService {

	List<Pacote> listAll();
	Pacote findByID(int id);
	Pacote findByName(String name);
	
	void addPacote(Pacote pacote);
	void updatePacote(Pacote pacote);
	void removePacote(Pacote pacote);
}
