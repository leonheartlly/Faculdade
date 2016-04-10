package org.unitri.ppi2.rest.resource;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.unitri.ppi2.rest.dao.ClienteDAO;
import org.unitri.ppi2.rest.domain.Cliente;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ClienteResource {

	@Inject
	private ClienteDAO clienteDAO;

	@POST
	@Transactional
	public Response create(Cliente cliente) {
		System.out.println("POST: " + cliente + " " + new Date());
		clienteDAO.insert(cliente);
		return Response.ok(cliente).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Cliente cliente = clienteDAO.findById(id);
		if (cliente == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(cliente).build();
	}

	@GET
	@Transactional
	public List<Cliente> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Cliente> clientes = clienteDAO.listAll();
		return clientes;
	}

	@GET
	@Transactional
	public List<Cliente> listAll() {
		final List<Cliente> clientes = clienteDAO.listAll();
		return clientes;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Cliente cliente) {
		cliente.setIdCliente(id);
		if (clienteDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		clienteDAO.update(cliente);
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if (clienteDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Cliente p = new Cliente();
		p.setIdCliente(id);
		clienteDAO.remove(p);
		return Response.ok().build();
	}
}
