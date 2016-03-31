package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Reserva;

public interface ReservaDao extends GenericDao<Reserva, Integer>{

	
	List<Reserva> listAll();
	Reserva findByID(int id);
	Reserva findByClienteID(int id);
	
	void addReserva(Reserva reserva);
	void updateReserva(Reserva reserva);
	void removeReserva(Reserva reserva);

}
