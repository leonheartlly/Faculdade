package br.com.unitri.agenciaturismo.model;


public class Destino {

	private int id;
	
	private String cidade;
	
	private String pais;
	
	private String link1;
	
	private String link2;
	
	private String link3;
	
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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

	@Override
	public String toString() {
		return "Destino [id=" + id + ", cidade=" + cidade + ", pais=" + pais
				+ ", link1=" + link1 + ", link2=" + link2 + ", link3=" + link3
				+ ", descricao=" + descricao + "]";
	}
	
	
}
