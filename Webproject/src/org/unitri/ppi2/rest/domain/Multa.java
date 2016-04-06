package org.unitri.ppi2.rest.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the multa database table.
 * 
 */
@Entity
@NamedQuery(name="Multa.findAll", query="SELECT m FROM Multa m")
public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_MULTA")
	private int idMulta;

	private String descricao;

	private double valor;

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

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

}