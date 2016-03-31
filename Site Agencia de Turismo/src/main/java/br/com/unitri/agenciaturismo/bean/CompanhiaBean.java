package br.com.unitri.agenciaturismo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.unitri.agenciaturismo.locator.ContextContainer;
import br.com.unitri.agenciaturismo.model.Companhia;

@ManagedBean(name="CompanhiaBean")
@SessionScoped
@Component
@Scope("session")
public class CompanhiaBean {
	
	private Companhia companhia;
	private  static List<Companhia> listCompanhia;
	public CompanhiaBean(){
		
		companhia = new Companhia();
		listCompanhia = new ArrayList<Companhia>();
	}
	
	
	public void adicionarCompanhia(){
		if(!companhia.equals(null))
		addCompanhia();
	}
	public void removerCompanhia(){
		if(!companhia.equals(null))
		deleteCompanhia();
	}
	public void updateCompanhia(){
		if(!companhia.equals(null))
		update();
	}
	public void listarCompanhias(){
		listCompanhia = listAll();
	}
	public void buscarCompanhiaPorID(int id){
		findCompanhiaByID(id);
	}
	public void buscarCompanihaPorNome(String name){
		findCompanhiaByName(name);
	}
	
	
	private void addCompanhia(){
		ContextContainer.getInstance().getCompanhiaService().addCompanhia(companhia);
	}
	private void deleteCompanhia(){
		ContextContainer.getInstance().getCompanhiaService().removeCompanhia(companhia);
	}
	private void update(){
		ContextContainer.getInstance().getCompanhiaService().updateCompanhia(companhia);
	}
	private void findCompanhiaByID(int id){
		ContextContainer.getInstance().getCompanhiaService().findByID(id);
	}
	private void findCompanhiaByName(String name){
		ContextContainer.getInstance().getCompanhiaService().findByName(name);
	}
	private List<Companhia> listAll(){
		List<Companhia> comp = new ArrayList<Companhia>();
		return comp = ContextContainer.getInstance().getCompanhiaService().listAll();
	}
	public Companhia getCompanhia() {
		return companhia;
	}
	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}
	
	
}
