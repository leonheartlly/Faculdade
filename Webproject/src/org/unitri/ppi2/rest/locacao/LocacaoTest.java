package org.unitri.ppi2.rest.locacao;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocacaoTest {
	
	/**
	 * URL utilizada para testes.
	 */
	public static String URL = "http://localhost:8180/Webproject/rest";
	
	public static HttpServer server;

	@BeforeClass
	public static void runBeforeClass(){
		//Inicia servico
		ResourceConfig config = new ResourceConfig().packages("org.unitri.ppi2.rest");
	    URI uri = URI.create(URL);
	    server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
	}
	
	@AfterClass
	public static void runAfterClass(){
		server.shutdown();
	}
	
	@Test
	public void test() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		
		String resultado = target.path("/veiculo/1").request().get(String.class);
		Assert.assertEquals("idVeiculo:1,marca:ford focus", resultado);
	}
	
}
