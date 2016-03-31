package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Destino;
import br.com.unitri.agenciaturismo.model.dao.DestinoDao;
import br.com.unitri.agenciaturismo.service.DestinoService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	DestinoDao destinoDao;
	
	public List<Destino> listAll() {
		return destinoDao.listAll();
	}

	public Destino findByID(int id) {
		return destinoDao.findByID(id);
	}

	public Destino findByCity(String city) {
		return destinoDao.findByCity(city);
	}

	public void addDestino(Destino destino) {
		destinoDao.addDestino(destino);
	}

	public void updateDestino(Destino destino) {
		destinoDao.updateDestino(destino);
	}

	public void removeDestino(Destino destino) {
		destinoDao.removeDestino(destino);
	}

}
