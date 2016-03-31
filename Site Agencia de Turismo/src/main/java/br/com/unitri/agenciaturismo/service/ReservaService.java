package br.com.unitri.agenciaturismo.service;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Reserva;

public interface ReservaService {

	List<Reserva> listAll();
	Reserva findByID(int id);
	Reserva findByClienteID(int id);
	
	void addReserva(Reserva reserva);
	void updateReserva(Reserva reserva);
	void removeReserva(Reserva reserva);
}
