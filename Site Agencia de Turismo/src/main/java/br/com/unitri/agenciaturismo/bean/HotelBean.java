package br.com.unitri.agenciaturismo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.unitri.agenciaturismo.locator.ContextContainer;
import br.com.unitri.agenciaturismo.model.Hotel;

@ManagedBean(name="HotelBean")
@SessionScoped
@Component
@Scope("session")
public class HotelBean {

	private Hotel hotel;
	
	
	public void adicionarHotel(){
		if(!hotel.equals(null))
		addHotel();
	}
	public void removerHotel(){
		if(!hotel.equals(null))
		removeHotel();
	}
	public void editarHotel(){
		if(!hotel.equals(null))
		update();
	}
	
	private void addHotel(){
		ContextContainer.getInstance().getHotelService().addHotel(hotel);
	}
	private void removeHotel(){
		ContextContainer.getInstance().getHotelService().removeHotel(hotel);
	}
	private void update(){
		ContextContainer.getInstance().getHotelService().updateHotel(hotel);
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
}
