package org.unitri.ppi2.rest.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the locacao database table.
 * 
 */
@Entity
@NamedQuery(name="Locacao.findAll", query="SELECT l FROM Locacao l")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LOCACAO")
	private int idLocacao;

	@Column(name="DATA_LOCACAO")
	private String dataLocacao;

	private String hora;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="ID_VEICULO")
	private Veiculo veiculo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="ID_FUNCIONARIO_CAD")
	private Funcionario funcionario1;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="ID_FUNCIONARIO_REC")
	private Funcionario funcionario2;

	//bi-directional many-to-many association to Avaria
	@ManyToMany
	@JoinTable(
		name="locacao_avaria"
		, joinColumns={
			@JoinColumn(name="ID_LOCACAO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_AVARIA")
			}
		)
	private List<Avaria> avarias;

	//bi-directional many-to-many association to Multa
	@ManyToMany
	@JoinTable(
		name="locacao_multa"
		, joinColumns={
			@JoinColumn(name="ID_LOCACAO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_MULTA")
			}
		)
	private List<Multa> multas;

	public Locacao() {
	}

	public int getIdLocacao() {
		return this.idLocacao;
	}

	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}

	public String getDataLocacao() {
		return this.dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario1() {
		return this.funcionario1;
	}

	public void setFuncionario1(Funcionario funcionario1) {
		this.funcionario1 = funcionario1;
	}

	public Funcionario getFuncionario2() {
		return this.funcionario2;
	}

	public void setFuncionario2(Funcionario funcionario2) {
		this.funcionario2 = funcionario2;
	}

	public List<Avaria> getAvarias() {
		return this.avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

	public List<Multa> getMultas() {
		return this.multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

}