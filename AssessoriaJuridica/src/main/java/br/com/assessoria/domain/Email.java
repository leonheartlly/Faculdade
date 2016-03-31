package br.com.assessoria.domain;

import br.com.assessoria.security.Encryptor;
import br.com.assessoria.util.AssessoriaJuridicaUtils;

public class Email {
	
	private String nomeEmail = AssessoriaJuridicaUtils.getProperty("nome.email");  
	private String remetente = AssessoriaJuridicaUtils.getProperty("endereco.email");
	private String servidorEmail = AssessoriaJuridicaUtils.getProperty("servidor.email");
	private Integer portaServidorEmail = Integer.parseInt(AssessoriaJuridicaUtils.getProperty("porta.servidor.email"));
	private String senha = Encryptor.decrypt(AssessoriaJuridicaUtils.getProperty("senha.email"));
	
	private String destinatario = "" ;
	private String nomeCliente = "";
	private String assunto; 
	private String texto;
	
	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getServidorEmail() {
		return servidorEmail;
	}

	public void setServidorEmail(String servidorEmail) {
		this.servidorEmail = servidorEmail;
	}

	public String getNomeEmail() {
		return nomeEmail;
	}

	public void setNomeEmail(String nomeEmail) {
		this.nomeEmail = nomeEmail;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getPortaServidorEmail() {
		return portaServidorEmail;
	}

	public void setPortaServidorEmail(Integer portaServidorEmail) {
		this.portaServidorEmail = portaServidorEmail;
	}
}
