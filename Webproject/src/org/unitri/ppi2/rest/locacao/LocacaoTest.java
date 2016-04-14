package org.unitri.ppi2.rest.locacao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.unitri.ppi2.rest.domain.Avaria;
import org.unitri.ppi2.rest.domain.Categoria;
import org.unitri.ppi2.rest.domain.Cliente;
import org.unitri.ppi2.rest.domain.Funcionario;
import org.unitri.ppi2.rest.domain.Locacao;
import org.unitri.ppi2.rest.domain.Multa;
import org.unitri.ppi2.rest.domain.Veiculo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoTest {	
	/**
	 * URL utilizada para testes.
	 */
	private static String URL = "http://localhost:8480/Webproject/rest";
	

	/*
	 * Veiculo
	 */
	
	@Test
	public void test01_createEntity(){
		int idVeiculo = 1;
		String marca = "Ford";
		
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/veiculo");

		Veiculo v = new Veiculo();
		v.setIdVeiculo(idVeiculo);
		v.setMarca(marca);

		Entity<Veiculo> entity = Entity.entity(v, MediaType.APPLICATION_JSON); 
		
		//Create Veiculo
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Veiculo] POST: "+status);
		
		Veiculo veiculo = response.readEntity(Veiculo.class);
		
		assertEquals(200, status);
		
		//Read Veiculo
		target = client.target(URL).path("/veiculo/"+idVeiculo);

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Veiculo] GET: "+status);
		
		veiculo = response.readEntity(Veiculo.class);

		assertEquals(200, status);
		assertEquals(veiculo.getIdVeiculo(), idVeiculo);
		assertEquals(veiculo.getMarca(), marca);
		
		//Update Veiculo
		marca = "Fiat";
				
		v.setMarca(marca);
				
		entity = Entity.entity(v, MediaType.APPLICATION_JSON); 
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Veiculo] PUT: "+status);
		
		assertEquals(200, status);

		//Delete Veiculo
		target = client.target(URL).path("/veiculo/"+idVeiculo);

		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Veiculo] DELETE: "+status);

		assertEquals(200, status);

	}

	
	/*
	 * Categoria
	 */
	@Test
	public void test02_createCategoria(){

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/categoria");

		Categoria c = new Categoria();
		c.setIdCategoria(1);
		c.setPreco(new BigDecimal(1000));

		Entity<Categoria> entity = Entity.entity(c, MediaType.APPLICATION_JSON); 
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Categoria] POST: "+status);
		
		Categoria categoria = response.readEntity(Categoria.class);
		
		assertEquals(200, status);
		assertEquals(categoria.getIdCategoria(), 1);
		assertEquals(categoria.getPreco(), new BigDecimal(1000));
	}
	
	/*
	 * Avaria
	 */
	@Test
	public void test03_createAvaria(){

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/avaria");

		Avaria a = new Avaria();
		a.setIdAvaria(1);
		a.setDescricao("Farol quebrado");

		Entity<Avaria> entity = Entity.entity(a, MediaType.APPLICATION_JSON); 
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Avaria] POST: "+status);
		
		Avaria avaria = response.readEntity(Avaria.class);
		
		assertEquals(200, status);
		assertEquals(avaria.getIdAvaria(), 1);
		assertEquals(avaria.getDescricao(), "Farol quebrado");
	}
	

	/*
	 * Multa
	 */
	@Test
	public void test04_createMulta(){

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/multa");

		Multa m = new Multa();
		m.setIdMulta(1);
		m.setDescricao("Estacionar em local proibido");

		Entity<Multa> entity = Entity.entity(m, MediaType.APPLICATION_JSON); 
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Multa] POST: "+status);
		
		Multa multa = response.readEntity(Multa.class);
		
		assertEquals(200, status);
		assertEquals(multa.getIdMulta(), 1);
		assertEquals(multa.getDescricao(), "Estacionar em local proibido");
	}
	
	/*
	 * Cliente
	 */
	@Test
	public void test05_createCliente(){

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/cliente");

		Cliente c = new Cliente();
		c.setIdCliente(1);
		c.setNome("Joaquim da Silva");

		Entity<Cliente> entity = Entity.entity(c, MediaType.APPLICATION_JSON); 
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Cliente] POST: "+status);
		
		Cliente cliente = response.readEntity(Cliente.class);
		
		assertEquals(200, status);
		assertEquals(cliente.getIdCliente(), 1);
		assertEquals(cliente.getNome(), "Joaquim da Silva");
	}
	
	/*
	 * Funcionario
	 */
	@Test
	public void test06_createFuncionario(){

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/funcionario");

		Funcionario f = new Funcionario();
		f.setIdfuncionario(1);
		f.setMatricula("1234");

		Entity<Funcionario> entity = Entity.entity(f, MediaType.APPLICATION_JSON); 
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Funcionario] POST: "+status);
		
		Funcionario funcionario = response.readEntity(Funcionario.class);
		
		assertEquals(200, status);
		assertEquals(funcionario.getIdfuncionario(), 1);
		assertEquals(funcionario.getMatricula(), "1234");
	}
	
	/*
	 * Locacao
	 */
	@Test
	public void test07_createLocacao(){

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/locacao");

		Locacao l = new Locacao();
		l.setIdLocacao(1);

		Entity<Locacao> entity = Entity.entity(l, MediaType.APPLICATION_JSON); 
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Locacao] POST: "+status);
		
		Locacao locacao = response.readEntity(Locacao.class);
		
		assertEquals(200, status);
		assertEquals(locacao.getIdLocacao(), 1);
	}
	
	/*
	 * Pesquisas
	 */
	@Test
	public void test08_getMultasPorLocacao(){
		GenericType<List<Multa>> LIST_MULTA_TYPE = new GenericType<List<Multa>>() {};
		
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/locacao/1");

		Response response = target.request(MediaType.APPLICATION_JSON).get();
		int status = response.getStatus();

		System.out.println("[Multa por locacao] GET List: "+status);

		List<Multa> multas = response.readEntity(LIST_MULTA_TYPE);

		assertEquals(200, status);
		assertEquals(1, multas.size());

	}
	
}
