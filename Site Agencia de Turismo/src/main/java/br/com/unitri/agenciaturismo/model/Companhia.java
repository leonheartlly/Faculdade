package br.com.unitri.agenciaturismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Companhia {

	private Long id;
	
	private String nome;
	
	private String cnpj;
	
	private String ddd;
	
	private String fone;
	
	private String tipoCompanhia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getTipoCompanhia() {
		return tipoCompanhia;
	}

	public void setTipoCompanhia(String tipoCompanhia) {
		this.tipoCompanhia = tipoCompanhia;
	}

	@Override
	public String toString() {
		return "Companhia [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", ddd=" + ddd + ", fone=" + fone + ", tipoCompanhia="
				+ tipoCompanhia + "]";
	}

	
	
}
