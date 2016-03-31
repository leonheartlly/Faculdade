package br.com.unitri.agenciaturismo.service;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Galeria;

public interface GaleriaService {

	List<Galeria> listAll();
	Galeria findByID(int id);
	Galeria findByName(String name);
	
	void addGaleria(Galeria galeria);
	void updateGaleria(Galeria galeria);
	void removeGaleria(Galeria galeria);
}
