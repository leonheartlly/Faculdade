package org.unitri.ppi2.rest.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the multa database table.
 * 
 */
@Entity
@NamedQuery(name="Multa.findAll", query="SELECT m FROM Multa m")
public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMulta;

	private String descricao;
	
	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	//bi-directional many-to-many association to Locacao
	@ManyToMany(mappedBy="multas")
	private List<Locacao> locacaos;

	public Multa() {
	}

	public int getIdMulta() {
		return this.idMulta;
	}

	public void setIdMulta(int idMulta) {
		this.idMulta = idMulta;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@XmlTransient
	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

}