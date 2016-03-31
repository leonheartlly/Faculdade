package br.com.unitri.agenciaturismo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Hotel;
import br.com.unitri.agenciaturismo.model.dao.HotelDao;
import br.com.unitri.agenciaturismo.service.HotelService;

@Service
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelDao hotelDao;
	
	public List<Hotel> listAll() {
		return hotelDao.listAll();
	}

	public Hotel findByCity(String city) {
		return hotelDao.findByCity(city);
	}

	public Hotel findByName(String name) {
		return hotelDao.findByName(name);
	}

	public void addHotel(Hotel hotel) {
		hotelDao.addHotel(hotel);
	}

	public void updateHotel(Hotel hotel) {
		hotelDao.updateHotel(hotel);
	}

	public void removeHotel(Hotel hotel) {
		hotelDao.removeHotel(hotel);
	}

}
