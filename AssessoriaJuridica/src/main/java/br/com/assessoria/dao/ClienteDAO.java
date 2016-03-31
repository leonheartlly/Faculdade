package br.com.assessoria.dao;

import java.util.List;

import br.com.assessoria.domain.Cliente;

public interface ClienteDAO {
	public boolean insert(Cliente c);
	public boolean delete(Cliente c);
	public boolean update(Cliente c);
	public  List<Cliente> searchAllClient();
	public  List<String> searchAll(String column, String table);
}
