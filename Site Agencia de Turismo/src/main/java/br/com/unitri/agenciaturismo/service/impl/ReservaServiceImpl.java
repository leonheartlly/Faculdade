package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Reserva;
import br.com.unitri.agenciaturismo.model.dao.ReservaDao;
import br.com.unitri.agenciaturismo.service.ReservaService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	ReservaDao reservaDao;
	
	public List<Reserva> listAll() {
		return reservaDao.listAll();
	}

	public Reserva findByID(int id) {
		return reservaDao.findByID(id);
	}

	public Reserva findByClienteID(int id) {
		return reservaDao.findByClienteID(id);
	}

	public void addReserva(Reserva reserva) {
		reservaDao.addReserva(reserva);
	}

	public void updateReserva(Reserva reserva) {
		reservaDao.updateReserva(reserva);
	}

	public void removeReserva(Reserva reserva) {
		reservaDao.removeReserva(reserva);
	}

}
