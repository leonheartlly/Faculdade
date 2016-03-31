package br.com.unitri.agenciaturismo.model.dao;

import java.util.List;

import br.com.unitri.agenciaturismo.model.Hotel;

public interface HotelDao extends GenericDao<Hotel, Integer>{

	
	List<Hotel> listAll();
	Hotel findByCity(String city);
	Hotel findByName(String name);
	
	void addHotel(Hotel hotel);
	void updateHotel(Hotel hotel);
	void removeHotel(Hotel hotel);

}
