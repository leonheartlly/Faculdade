package br.com.unitri.agenciaturismo.model;


public class Funcionario {

	private int id;
	
	private String nome;
	
	private String idade;
	
	private String cpf;
	
	private String email;
	
	private String sexo;
	
	private String fone;
	
	private String ddd;
	
	private String endereco;
	
	private String bairro;
	
	private String estado;
	
	private String cep;
	
	private String pais;
	
	private String username;

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

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", idade=" + idade
				+ ", cpf=" + cpf + ", email=" + email + ", sexo=" + sexo
				+ ", fone=" + fone + ", ddd=" + ddd + ", endereco=" + endereco
				+ ", bairro=" + bairro + ", estado=" + estado + ", cep=" + cep
				+ ", pais=" + pais + ", username=" + username + "]";
	}
	
	
	
}
