package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Companhia;
import br.com.unitri.agenciaturismo.model.dao.CompanhiaDao;
import br.com.unitri.agenciaturismo.service.CompanhiaService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class CompanhiaServiceImpl implements CompanhiaService {

	@Autowired
	CompanhiaDao companhiaDao;
	
	public List<Companhia> listAll() {
		return companhiaDao.listAll();
	}

	public Companhia findByID(int id) {
		return companhiaDao.findByID(id);
	}

	public Companhia findByName(String name) {
		return companhiaDao.findByName(name);
	}

	public void addCompanhia(Companhia companhia) {
		companhiaDao.addCompanhia(companhia);
	}

	public void updateCompanhia(Companhia companhia) {
		companhiaDao.updateCompanhia(companhia);
	}

	public void removeCompanhia(Companhia companhia) {
		companhiaDao.removeCompanhia(companhia);
	}

}
