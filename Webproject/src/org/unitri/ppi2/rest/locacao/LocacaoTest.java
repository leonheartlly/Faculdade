package org.unitri.ppi2.rest.locacao;

import static org.junit.Assert.*;
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
import org.unitri.ppi2.rest.domain.Veiculo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoTest {	
	/**
	 * URL utilizada para testes.
	 */
	private static String URL = "http://localhost:8480/Webproject/rest";
	

	@Test
	public void test01_postMethod(){

		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);

		//client.register(GsonMessageBodyHandler.class);
		WebTarget target = client.target(URL).path("/veiculo");

		Veiculo v = new Veiculo();
		v.setIdVeiculo(1);
		v.setMarca("Ford");

		Entity<Veiculo> entity = Entity.entity(v, MediaType.APPLICATION_JSON); 
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
		int status = response.getStatus();

		System.out.println("POST: "+status);
		//System.out.println(response);
		
		Veiculo veiculo = response.readEntity(Veiculo.class);
		System.out.println(veiculo);
		
		assertEquals(200, status);
		assertEquals(veiculo.getIdVeiculo(), 1);
	}
}
