package org.unitri.ppi2.rest.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the avaria database table.
 * 
 */
@Entity
@NamedQuery(name="Avaria.findAll", query="SELECT a FROM Avaria a")
public class Avaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAvaria;

	private String descricao;

	private BigDecimal valor;

	//bi-directional many-to-many association to Locacao
	@ManyToMany(mappedBy="avarias")
	private List<Locacao> locacaos;

	public Avaria() {
	}
	
	public Avaria(Locacao locacao){
		this.descricao = "";
		this.valor = new BigDecimal(0);
		this.locacaos = new ArrayList<Locacao>();
		this.locacaos.add(locacao);
	}

	public int getIdAvaria() {
		return this.idAvaria;
	}

	public void setIdAvaria(int idAvaria) {
		this.idAvaria = idAvaria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@XmlTransient
	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

}