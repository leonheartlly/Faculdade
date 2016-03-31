package br.com.unitri.agenciaturismo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.unitri.agenciaturismo.locator.ContextContainer;
import br.com.unitri.agenciaturismo.model.Cliente;
import br.com.unitri.agenciaturismo.model.UserRoles;
import br.com.unitri.agenciaturismo.model.Users;

@ManagedBean(name="ClienteBean")
@SessionScoped
@Component
@Scope("session")
public class ClienteBean {

	private static Cliente cliente;
	private static Users user;
	private static UserRoles userRoles;
	private static List<Cliente> listaClientes;
	
	public ClienteBean() {
		cliente = new Cliente();
		user = new Users();
		userRoles = new UserRoles();
		listaClientes = new ArrayList<Cliente>();
	}
	
	
//	@PostConstruct
//	public void init(){
//		listAll();
//	}
	
	
	public void adicionarCliente(){
		if(!cliente.equals(null) && !user.equals(null)){
			addUser();
			addUseRoles();
			addCliente();
		}
		cliente = new Cliente();
		user = new Users();
		userRoles = new UserRoles();
	}
	
	public void removerCliente(String username){
		
		if(!cliente.equals(null) && !user.equals(null) && !userRoles.equals(null)){
			Cliente cli = new Cliente();
			cli.setUsername(username);
			removeCliente(cli);
			Users user = new Users();
			user.setUsername(username);
			UserRoles uR = new UserRoles();
			uR.setUsername(username);
			removeUseRoles(uR);
			removeUser(user);
		}
		cliente = new Cliente();
	}
	
	public void updateCliente(Cliente cliente){
		
		if(!cliente.equals(null) && !user.equals(null) && !userRoles.equals(null)){
			update(cliente);
		}
	}
	
	public void listarClientes(){
		listaClientes = listAll();
	}
	public void buscarClientePorID(int id){
		findByID(id);
	}
	public void buscarClientePorNome(String nome){
		findByName(nome);
	}
	
	private void addCliente(){
		cliente.setUsername(user.getUsername());
		ContextContainer.getInstance().getClienteService().addPessoa(cliente);
	}
	private void removeCliente(Cliente cliente){
		ContextContainer.getInstance().getClienteService().removePessoa(cliente);
	}
	private void update(Cliente cliente){
		ContextContainer.getInstance().getClienteService().updatePessoa(cliente);
	}
	private void addUser(){
		user.setEnabled(true);
		ContextContainer.getInstance().getUsersService().addUsers(user);
	}
	private void addUseRoles(){
		userRoles.setUsername(user.getUsername());
		userRoles.setRole("ROLE_USER");
		ContextContainer.getInstance().getUserRolesService().add(userRoles);
	}
	private void removeUser(Users user){
		ContextContainer.getInstance().getUsersService().removeUsers(user);
	}
	private void removeUseRoles(UserRoles userRoles){
		ContextContainer.getInstance().getUserRolesService().remove(userRoles);
	}
	private List<Cliente> listAll(){
		List<Cliente> list = new ArrayList<Cliente>();
		list = ContextContainer.getInstance().getClienteService().listAll();
		return list;
	}
	private void findByID(int id){
		ContextContainer.getInstance().getClienteService().findByID(id);
	}
	private void findByName(String nome){
		ContextContainer.getInstance().getClienteService().findByName(nome);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
