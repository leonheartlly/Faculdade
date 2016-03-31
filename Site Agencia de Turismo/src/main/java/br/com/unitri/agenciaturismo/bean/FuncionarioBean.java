package br.com.unitri.agenciaturismo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.unitri.agenciaturismo.locator.ContextContainer;
import br.com.unitri.agenciaturismo.model.Funcionario;
import br.com.unitri.agenciaturismo.model.UserRoles;
import br.com.unitri.agenciaturismo.model.Users;

@ManagedBean(name="FuncionarioBean")
@SessionScoped
@Component
@Scope("session")
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	private Users user = new Users();
	private UserRoles userRoles = new UserRoles();
	private List<Funcionario> listaFuncionario;
	
	public void adicionarFuncionario(){
		if(!funcionario.equals(null) && !user.equals(null)){
			addUser();
			addUseRoles();
			addFuncionario();
		}
		funcionario = new Funcionario();
	}
	
	public void removerFuncionario(){
		
		if(!funcionario.equals(null) && !user.equals(null) && !userRoles.equals(null)){
			removeFuncionario();
			removeUseRoles();
			removeUser();
		}
		
	}
	
	public void updateFuncionario(){
		if(!funcionario.equals(null) && !user.equals(null) && !userRoles.equals(null)){
			update();
		}
	}
	
	public void listarFuncionarios(){
		listAll();
	}
	public void buscarFuncionarioPorID(int id){
		findByID(id);
	}
	public void buscarFuncionarioPorNome(String nome){
		findByName(nome);
	}
	
	private void addFuncionario(){
		funcionario.setUsername(user.getUsername());
		ContextContainer.getInstance().getFuncionarioService().addFuncionario(funcionario);
	}
	private void removeFuncionario(){
		ContextContainer.getInstance().getFuncionarioService().removeFuncionario(funcionario);
	}
	private void update(){
		ContextContainer.getInstance().getFuncionarioService().updateFuncionario(funcionario);
	}
	private void addUser(){
		user.setEnabled(true);
		ContextContainer.getInstance().getUsersService().addUsers(user);
	}
	private void addUseRoles(){
		userRoles.setUsername(user.getUsername());
		userRoles.setRole("ROLE_ADMIN");
		ContextContainer.getInstance().getUserRolesService().add(userRoles);
	}
	private void removeUser(){
		ContextContainer.getInstance().getUsersService().removeUsers(user);
	}
	private void removeUseRoles(){
		ContextContainer.getInstance().getUserRolesService().remove(userRoles);
	}
	private void listAll(){
		ContextContainer.getInstance().getFuncionarioService().listAll();
	}
	private void findByID(int id){
		ContextContainer.getInstance().getFuncionarioService().findByID(id);
	}
	private void findByName(String nome){
		ContextContainer.getInstance().getFuncionarioService().findByName(nome);
	}
	
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public UserRoles getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	
	
}
