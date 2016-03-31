package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Galeria;
import br.com.unitri.agenciaturismo.model.dao.GaleriaDao;
import br.com.unitri.agenciaturismo.service.GaleriaService;


public class GaleriaServiceImpl implements GaleriaService {

	@Autowired
	GaleriaDao galeriaDao;
	
	public List<Galeria> listAll() {
		return galeriaDao.listAll();
	}

	public Galeria findByID(int id) {
		return galeriaDao.findByID(id);
	}

	public Galeria findByName(String name) {
		return galeriaDao.findByName(name);
	}

	public void addGaleria(Galeria galeria) {
		galeriaDao.addGaleria(galeria);
	}

	public void updateGaleria(Galeria galeria) {
		galeriaDao.updateGaleria(galeria);
	}

	public void removeGaleria(Galeria galeria) {
		galeriaDao.removeGaleria(galeria);
	}

}
