package br.com.unitri.agenciaturismo.service;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Hotel;

public interface HotelService {

	List<Hotel> listAll();
	Hotel findByCity(String city);
	Hotel findByName(String name);
	
	void addHotel(Hotel hotel);
	void updateHotel(Hotel hotel);
	void removeHotel(Hotel hotel);
}
