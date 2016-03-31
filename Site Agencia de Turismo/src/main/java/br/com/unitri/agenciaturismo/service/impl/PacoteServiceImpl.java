package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Pacote;
import br.com.unitri.agenciaturismo.model.dao.PacoteDao;
import br.com.unitri.agenciaturismo.service.PacoteService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class PacoteServiceImpl implements PacoteService {

	@Autowired
	PacoteDao pacoteDao;
	
	public List<Pacote> listAll() {
		return pacoteDao.listAll();
	}

	public Pacote findByID(int id) {
		return pacoteDao.findByID(id);
	}

	public Pacote findByName(String name) {
		return pacoteDao.findByName(name);
	}

	public void addPacote(Pacote pacote) {
		pacoteDao.addPacote(pacote);
	}

	public void updatePacote(Pacote pacote) {
		pacoteDao.updatePacote(pacote);
	}

	public void removePacote(Pacote pacote) {
		pacoteDao.removePacote(pacote);
	}

}
