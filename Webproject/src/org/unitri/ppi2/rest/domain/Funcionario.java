package org.unitri.ppi2.rest.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idfuncionario;

	private String matricula;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="funcionario1")
	private List<Locacao> locacaos1;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="funcionario2")
	private List<Locacao> locacaos2;

	public Funcionario() {
	}

	public int getIdfuncionario() {
		return this.idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Locacao> getLocacaos1() {
		return this.locacaos1;
	}

	public void setLocacaos1(List<Locacao> locacaos1) {
		this.locacaos1 = locacaos1;
	}

	public Locacao addLocacaos1(Locacao locacaos1) {
		getLocacaos1().add(locacaos1);
		locacaos1.setFuncionario1(this);

		return locacaos1;
	}

	public Locacao removeLocacaos1(Locacao locacaos1) {
		getLocacaos1().remove(locacaos1);
		locacaos1.setFuncionario1(null);

		return locacaos1;
	}

	public List<Locacao> getLocacaos2() {
		return this.locacaos2;
	}

	public void setLocacaos2(List<Locacao> locacaos2) {
		this.locacaos2 = locacaos2;
	}

	public Locacao addLocacaos2(Locacao locacaos2) {
		getLocacaos2().add(locacaos2);
		locacaos2.setFuncionario2(this);

		return locacaos2;
	}

	public Locacao removeLocacaos2(Locacao locacaos2) {
		getLocacaos2().remove(locacaos2);
		locacaos2.setFuncionario2(null);

		return locacaos2;
	}

}