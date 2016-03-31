package br.com.assessoria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.assessoria.dao.ClienteDAO;
import br.com.assessoria.domain.Cliente;
import br.com.assessoria.util.AssessoriaJuridicaUtils;
import br.com.assessoria.util.Conexao;

public class ClienteDAOImpl implements ClienteDAO{
	private static final Logger LOGGER = Logger.getLogger(AssessoriaJuridicaUtils.class.getName());
	
	@Override
	public boolean insert(Cliente c){
		Connection connection = new Conexao().conectar();
		String sqlInsert = "INSERT INTO Cliente(Nome_Cliente, Nome_Fantasia, Numero_Oab, Cnpj, logradouro, Numero, Complemento, Bairro, Cidade, Cep, Telefone, Celular, Email) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sqlInsert);
			
			stm.setString(1, c.getNomeCliente());
			stm.setString(2, c.getNomeFantasia());
			stm.setString(3, c.getNumeroOab());
			stm.setString(4, c.getCnpj());
			stm.setString(5, c.getLogradouro());
			stm.setLong(6, c.getNumero());
			stm.setString(7, c.getComplemento());
			stm.setString(8, c.getBairro());
			stm.setString(9, c.getCidade());
			stm.setString(10, c.getCep());
			stm.setString(11, c.getTelefone());
			stm.setString(12, c.getCelular());
			stm.setString(13, c.getEmail());
			stm.execute();
			return true;
		} catch (Exception e) {
			LOGGER.error("Erro ao adicionar cliente: " + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				LOGGER.error("Erro ao fazer rollback: " + e1.getMessage());
			}
			return false;
		}
		finally {
			if (stm != null){
				try {
					stm.close();
					 new Conexao().desconectar(connection);
				} catch (SQLException e) {
					LOGGER.error("Erro ao desconectar do banco: " + e.getMessage());
				}
			}else{
				
			}
		}
	}

	@Override
	public boolean delete(Cliente c){
		Connection connection = new Conexao().conectar();
		String sqlDelete = "DELETE FROM Cliente WHERE Cod_Cli = ?";
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sqlDelete);

			stm.setInt(1, c.getCodCliente());
			
			stm.execute();
			return true;
		} catch (Exception e) {
			LOGGER.error("Erro ao remover cliente: " + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				LOGGER.error("Erro ao fazer rollback: " + e1.getMessage());
			}
			return false;
		}
		finally {
			if (stm != null){
				try {
					stm.close();
					 new Conexao().desconectar(connection);
				} catch (SQLException e) {
					LOGGER.error("Erro ao desconectar do banco: " + e.getMessage());
				}
			}else{
				
			}
		}
	}

	@Override
	public boolean update(Cliente c){
		Connection connection = new Conexao().conectar();
		String sqlInsert = "UPDATE Cliente SET Nome_Cliente = ?, Nome_Fantasia = ?, Numero_Oab = ?, Cnpj = ?, logradouro = ?, Numero = ?, Complemento = ?, Bairro = ?, Cidade = ?, Cep = ?, Telefone = ?, Celular = ?, Email = ? WHERE Cod_Cli = ?" ;
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sqlInsert);

			stm.setString(1, c.getNomeCliente());
			stm.setString(2, c.getNomeFantasia());
			stm.setString(3, c.getNumeroOab());
			stm.setString(4, c.getCnpj());
			stm.setString(5, c.getLogradouro());
			stm.setLong(6, c.getNumero());
			stm.setString(7, c.getComplemento());
			stm.setString(8, c.getBairro());
			stm.setString(9, c.getCidade());
			stm.setString(10, c.getCep());
			stm.setString(11, c.getTelefone());
			stm.setString(12, c.getCelular());
			stm.setString(13, c.getEmail());
			stm.setInt(14, c.getCodCliente());
			stm.execute();
			return true;
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar cliente: " + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				LOGGER.error("Erro ao fazer rollback: " + e1.getMessage());
			}
			return false;
		}
		finally {
			if (stm != null){
				try {
					stm.close();
					 new Conexao().desconectar(connection);
				} catch (SQLException e) {
					LOGGER.error("Erro ao desconectar do banco: " + e.getMessage());
				}
			}else{
				
			}
		}
	}

	@Override
	public List<Cliente> searchAllClient() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente;
		Connection connection = new Conexao().conectar();
		String sqlSelect = "SELECT Cod_Cli, Nome_Cliente, Nome_Fantasia, Numero_Oab, Cnpj, logradouro, Numero, Complemento, Bairro, Cidade, Cep, Telefone, Celular, Email FROM Cliente";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = connection.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while(rs.next()){
				cliente = new Cliente();
				cliente.setCodCliente(rs.getInt(1));
				cliente.setNomeCliente(rs.getString(2));
				cliente.setNomeFantasia(rs.getString(3));
				cliente.setNumeroOab(rs.getString(4));
				cliente.setCnpj(rs.getString(5));
				cliente.setLogradouro(rs.getString(6));
				cliente.setNumero(rs.getInt(7));
				cliente.setComplemento(rs.getString(8));
				cliente.setBairro(rs.getString(9));
				cliente.setCidade(rs.getString(10));
				cliente.setCep(rs.getString(11));
				cliente.setTelefone(rs.getString(12));
				cliente.setCelular(rs.getString(13));
				cliente.setEmail(rs.getString(14));
				
				clientes.add(cliente);
			}
		 } catch (Exception e) {
			 LOGGER.error("Erro ao buscar cliente: " + e.getMessage());
			 try {
				 connection.rollback();
			 } catch (SQLException e1) {
				 LOGGER.error("Erro ao Realizar Rollback: " + e1.getMessage());
			 }
		} finally {
			if (stm != null){
				try {
					stm.close();
					 new Conexao().desconectar(connection);
				} catch (SQLException e) {
					LOGGER.error("Erro ao desconectar do banco: " + e.getMessage());
				}
			}else{
				
			}
		}
		return clientes;
	}
	
	public  List<String> searchAll(String column, String table){
		List<String> values = new ArrayList<String>();
		String value;
		Connection connection = new Conexao().conectar();
		String sqlSelect = "SELECT "+ column +" FROM " + table;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = connection.prepareStatement(sqlSelect);
//			stm.setString(1, column);
//			stm.setString(2, table);
			rs = stm.executeQuery();
			while(rs.next()){
				 value = rs.getString(1);
				 values.add(value);
			}
		 } catch (Exception e) {
			 LOGGER.error("Erro ao buscar cidade: " + e.getMessage());
			 try {
				 connection.rollback();
			 } catch (SQLException e1) {
				 LOGGER.error("Erro ao Realizar Rollback: " + e1.getMessage());
			 }
		} finally {
			if (stm != null){
				try {
					stm.close();
					 new Conexao().desconectar(connection);
				} catch (SQLException e) {
					LOGGER.error("Erro ao desconectar do banco: " + e.getMessage());
				}
			}else{
				
			}
		}
		return values;
	}
}
