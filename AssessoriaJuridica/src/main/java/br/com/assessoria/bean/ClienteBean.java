package br.com.assessoria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.assessoria.dao.impl.ClienteDAOImpl;
import br.com.assessoria.domain.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private ClienteDAOImpl clienteDaoImpl;
	private String column;
	private String table;
	
	public ClienteBean() {
		clienteDaoImpl = new ClienteDAOImpl();
	}
	
	public void salvar() {
		if(cliente.getCodCliente() == null ){
	        if(clienteDaoImpl.insert(cliente)){
	        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso!",""));
	        }
		}else{
			 if(clienteDaoImpl.update(cliente)){
		        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente atualizado com sucesso!",""));
		        }
		}
        limpar();
    }
	
	public void limpar() {
        cliente = new Cliente();
    }
	
	public void remover(){
		if(clienteDaoImpl.delete(cliente)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente removido com sucesso!",""));
		}
	}
	
	public List<String> getCidades(){
		column = "Cidade";
		table = "Cidades";
		return clienteDaoImpl.searchAll(column, table);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clienteDaoImpl.searchAllClient();
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
