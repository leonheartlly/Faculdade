package org.unitri.ppi2.rest.locacao;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
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
	public void test01_createEntity() {
		int idVeiculo = 1;
		String marca = "Ford";

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/veiculo");

		Veiculo v = new Veiculo();
		v.setIdVeiculo(idVeiculo);
		v.setMarca(marca);

		Entity<Veiculo> entity = Entity.entity(v, MediaType.APPLICATION_JSON);

		// Create Veiculo
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Veiculo] POST: " + status);

		Veiculo veiculo = response.readEntity(Veiculo.class);

		assertEquals(200, status);

		// Read Veiculo
		target = client.target(URL).path("/veiculo/" + idVeiculo);

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Veiculo] GET: " + status);

		veiculo = response.readEntity(Veiculo.class);

		assertEquals(200, status);
		assertEquals(veiculo.getIdVeiculo(), idVeiculo);
		assertEquals(veiculo.getMarca(), marca);

		// Update Veiculo
		v.setMarca("Fiat");

		entity = Entity.entity(v, MediaType.APPLICATION_JSON);
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Veiculo] PUT: " + status);

		assertEquals(200, status);

		// Delete Veiculo
		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Veiculo] DELETE: " + status);

		assertEquals(200, status);

	}

	/*
	 * Categoria
	 */
	@Test
	public void test02_createCategoria() {

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/categoria");

		Categoria c = new Categoria();
		c.setIdCategoria(1);
		c.setPreco(new BigDecimal(1000));

		Entity<Categoria> entity = Entity.entity(c, MediaType.APPLICATION_JSON);

		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Categoria] POST: " + status);

		Categoria categoria = response.readEntity(Categoria.class);

		assertEquals(200, status);

		// Read Categoria
		target = client.target(URL).path("/categoria/1");

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Categoria] GET: " + status);

		categoria = response.readEntity(Categoria.class);

		assertEquals(200, status);
		assertEquals(categoria.getIdCategoria(), 1);

		// Update Categoria
		c.setPreco(new BigDecimal(2000));

		entity = Entity.entity(c, MediaType.APPLICATION_JSON);
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Categoria] PUT: " + status);

		assertEquals(200, status);

		// Delete Categoria
		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Categoria] DELETE: " + status);

		assertEquals(200, status);
	}

	/*
	 * Avaria
	 */
	@Test
	public void test03_createAvaria() {

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/avaria");

		Avaria a = new Avaria();
		a.setIdAvaria(1);
		a.setDescricao("Farol quebrado");

		Entity<Avaria> entity = Entity.entity(a, MediaType.APPLICATION_JSON);

		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Avaria] POST: " + status);

		Avaria avaria = response.readEntity(Avaria.class);

		assertEquals(200, status);

		// Read Avaria
		target = client.target(URL).path("/avaria/1");

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Avaria] GET: " + status);

		avaria = response.readEntity(Avaria.class);

		assertEquals(200, status);
		assertEquals(avaria.getIdAvaria(), 1);
		assertEquals(avaria.getDescricao(), "Farol quebrado");

		// Update Avaria
		a.setDescricao("Pneu furado");

		entity = Entity.entity(a, MediaType.APPLICATION_JSON);
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Avaria] PUT: " + status);

		assertEquals(200, status);

		// Delete Avaria
		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Avaria] DELETE: " + status);

		assertEquals(200, status);
	}

	/*
	 * Multa
	 */
	@Test
	public void test04_createMulta() {

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/multa");

		Multa m = new Multa();
		m.setIdMulta(1);
		m.setDescricao("Estacionar em local proibido");

		Entity<Multa> entity = Entity.entity(m, MediaType.APPLICATION_JSON);

		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Multa] POST: " + status);

		Multa multa = response.readEntity(Multa.class);

		assertEquals(200, status);

		// Read Multa
		target = client.target(URL).path("/multa/1");

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Avaria] GET: " + status);

		multa = response.readEntity(Multa.class);

		assertEquals(200, status);
		assertEquals(multa.getIdMulta(), 1);
		assertEquals(multa.getDescricao(), "Estacionar em local proibido");

		// Update Multa
		m.setDescricao("Pneu furado");

		entity = Entity.entity(m, MediaType.APPLICATION_JSON);
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Multa] PUT: " + status);

		assertEquals(200, status);

		// Delete Multa
		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Multa] DELETE: " + status);

		assertEquals(200, status);
	}

	/*
	 * Cliente
	 */
	@Test
	public void test05_createCliente() {

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/cliente");

		Cliente c = new Cliente();
		c.setIdCliente(1);
		c.setNome("Joaquim da Silva");

		Entity<Cliente> entity = Entity.entity(c, MediaType.APPLICATION_JSON);

		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Cliente] POST: " + status);

		Cliente cliente = response.readEntity(Cliente.class);

		assertEquals(200, status);

		// Read Cliente
		target = client.target(URL).path("/cliente/1");

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Cliente] GET: " + status);

		cliente = response.readEntity(Cliente.class);

		assertEquals(200, status);
		assertEquals(cliente.getIdCliente(), 1);
		assertEquals(cliente.getNome(), "Joaquim da Silva");

		// Update Cliente
		c.setNome("Joao de Moraes");

		entity = Entity.entity(c, MediaType.APPLICATION_JSON);
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Cliente] PUT: " + status);

		assertEquals(200, status);

		// Delete Cliente
		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Cliente] DELETE: " + status);

		assertEquals(200, status);
	}

	/*
	 * Funcionario
	 */
	@Test
	public void test06_createFuncionario() {

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/funcionario");

		Funcionario f = new Funcionario();
		f.setIdfuncionario(1);
		f.setMatricula("1234");

		Entity<Funcionario> entity = Entity.entity(f, MediaType.APPLICATION_JSON);

		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Funcionario] POST: " + status);

		Funcionario funcionario = response.readEntity(Funcionario.class);

		assertEquals(200, status);

		// Read Funcionario
		target = client.target(URL).path("/funcionario/1");

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Funcionario] GET: " + status);

		funcionario = response.readEntity(Funcionario.class);

		assertEquals(200, status);
		assertEquals(funcionario.getIdfuncionario(), 1);
		assertEquals(funcionario.getMatricula(), "1234");

		// Update Funcionario
		f.setMatricula("5678");

		entity = Entity.entity(f, MediaType.APPLICATION_JSON);
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Funcionario] PUT: " + status);

		assertEquals(200, status);

		// Delete Funcionario
		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Funcionario] DELETE: " + status);

		assertEquals(200, status);
	}

	/*
	 * Locacao
	 */
	@Test
	public void test07_createLocacao() {

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/locacao");

		Locacao l = new Locacao();
		l.setIdLocacao(1);

		Cliente c = new Cliente();
		c.setIdCliente(3);
		c.setNome("Maria da Silva");

		l.setCliente(c);

		Entity<Locacao> entity = Entity.entity(l, MediaType.APPLICATION_JSON);

		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("[Locacao] POST: " + status);

		Locacao locacao = response.readEntity(Locacao.class);

		assertEquals(200, status);

		// Read Locacao
		target = client.target(URL).path("/locacao/1");

		response = target.request(MediaType.APPLICATION_JSON).get();
		status = response.getStatus();

		System.out.println("[Locacao] GET: " + status);

		locacao = response.readEntity(Locacao.class);

		assertEquals(200, status);
		assertEquals(locacao.getIdLocacao(), 1);

		// Update Locacao
		c = new Cliente();
		c.setIdCliente(4);
		c.setNome("Joana da Fonseca");

		l.setCliente(c);

		entity = Entity.entity(l, MediaType.APPLICATION_JSON);
		response = target.request(MediaType.APPLICATION_JSON).put(entity, Response.class);
		status = response.getStatus();

		System.out.println("[Locacao] PUT: " + status);

		//assertEquals(200, status);

		// Delete Locacao
		response = target.request(MediaType.APPLICATION_JSON).delete();
		status = response.getStatus();

		System.out.println("[Locacao] DELETE: " + status);

		assertEquals(200, status);

	}

	/*
	 * Pesquisas
	 */
	@Test
	public void test08_getMultasPorLocacao() {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/locacao/1");

		Response response = target.request(MediaType.APPLICATION_JSON).get();
		int status = response.getStatus();

		System.out.println("[Multa por locacao] GET List: " + status);

		assertEquals(200, status);

	}

	@Test
	public void test09_getVeiculosPorCategoria() {
		// TODO

	}

	@Test
	public void test10_getAvariasPorLocacao() {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget target = client.target(URL).path("/locacao/1");

		Response response = target.request(MediaType.APPLICATION_JSON).get();
		int status = response.getStatus();

		System.out.println("[Avaria por locacao] GET List: " + status);

		assertEquals(200, status);
	}

	@Test
	public void test11_getLocacaoPorFuncionario() {
		// TODO
	}

	@Test
	public void test12_getLocacaoPorVeiculo() {
		// TODO
	}

	@Test
	public void test13_getLocacaoPorMes() {
		// TODO
	}

	@Test
	public void test11_getMelhorClienteMes() {
		// TODO
	}

}
