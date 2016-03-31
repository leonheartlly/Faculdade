package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Galeria;

public interface GaleriaDao extends GenericDao<Galeria, Integer>{

	
	List<Galeria> listAll();
	Galeria findByID(int id);
	Galeria findByName(String name);
	
	void addGaleria(Galeria galeria);
	void updateGaleria(Galeria galeria);
	void removeGaleria(Galeria galeria);

}
