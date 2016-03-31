package br.com.unitri.agenciaturismo.model;


public class Hotel {

	private int id;
	
	private String nome;
	
	private String cnpj;
	
	private String estrelas;
	
	private float preco;
	
	private String ddd;
	
	private String fone;
	
	private int quantidadeQuartos;
	
	private String pais;
	
	private String linkTitle;
	
	private String link1;
	
	private String link2;
	
	private String link3;
	
	private String descricao;
	
	private String cidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(String estrelas) {
		this.estrelas = estrelas;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public String getLink1() {
		return link1;
	}

	public void setLink1(String link1) {
		this.link1 = link1;
	}

	public String getLink2() {
		return link2;
	}

	public void setLink2(String link2) {
		this.link2 = link2;
	}

	public String getLink3() {
		return link3;
	}

	public void setLink3(String link3) {
		this.link3 = link3;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeQuartos() {
		return quantidadeQuartos;
	}

	public void setQuantidadeQuartos(int quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", estrelas=" + estrelas + ", preco=" + preco + ", ddd="
				+ ddd + ", fone=" + fone + ", quantidadeQuartos="
				+ quantidadeQuartos + ", pais=" + pais + ", linkTitle="
				+ linkTitle + ", link1=" + link1 + ", link2=" + link2
				+ ", link3=" + link3 + ", descricao=" + descricao + ", cidade="
				+ cidade + "]";
	}

	
	
	
}
