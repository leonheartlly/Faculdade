package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Destino;

public interface DestinoDao{

	
	List<Destino> listAll();
	Destino findByID(int id);
	Destino findByCity(String city);
	
	void addDestino(Destino destino);
	void updateDestino(Destino destino);
	void removeDestino(Destino destino);
}
