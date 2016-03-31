package br.com.unitri.agenciaturismo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.unitri.agenciaturismo.locator.ContextContainer;
import br.com.unitri.agenciaturismo.model.Destino;

@ManagedBean(name="DestinoBean")
@SessionScoped
@Component
@Scope("session")
public class DestinoBean {

	private Destino destino;
	
	public void adicionarDestino(){
		if(!getDestino().equals(null))
		addDestino();
	}
	public void removerDestino(){
		if(!getDestino().equals(null))
		deleteDestino();
	}
	public void updateDestino(){
		if(!getDestino().equals(null))
		update();
	}
	public void listarCompanhias(){
		listAll();
	}
	public void buscarDestinoPorID(int id){
		findDestinoByID(id);
	}
	public void buscarDestinoPorCidade(String cidade){
		findDestinoByCity(cidade);
	}
	
	
	private void addDestino(){
		ContextContainer.getInstance().getDestinoService().addDestino(getDestino());
	}
	private void deleteDestino(){
		ContextContainer.getInstance().getDestinoService().removeDestino(getDestino());
	}
	private void update(){
		ContextContainer.getInstance().getDestinoService().updateDestino(getDestino());
	}
	private void findDestinoByID(int id){
		ContextContainer.getInstance().getDestinoService().findByID(id);
	}
	private void findDestinoByCity(String city){
		ContextContainer.getInstance().getDestinoService().findByCity(city);
	}
	private void listAll(){
		ContextContainer.getInstance().getDestinoService().listAll();
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	
}
