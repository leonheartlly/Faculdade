package br.com.unitri.agenciaturismo.model;


public class Reserva {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private int quantidade;
	
	private int idCliente;
	
	private int idPacote;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
