package com.algaworks.cursojsf2.financeiro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//anotações do hibernate
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {

	private Integer codigo;
	private String nome;
	
	public Pessoa() {
	}
	
	public Pessoa(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	@Id //informa que é um campo que nunca irá se repetir
	@GeneratedValue //informa que é um campo auto increment, o BD que gera os valores
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Column(name="nome")//desnecessário o name pois o nome coincide com a tabela (por este motivo, sem o column tb funfa)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}