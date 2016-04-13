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

import org.unitri.ppi2.rest.dao.MultaDAO;
import org.unitri.ppi2.rest.domain.Multa;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/multa")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class MultaResource {

	@Inject
	private MultaDAO multaDAO;

	@POST
	@Transactional
	public Response create(Multa multa) {
		System.out.println("POST: " + multa + " " + new Date());
		multaDAO.insert(multa);
		return Response.ok(multa).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Multa multa = multaDAO.findById(id);
		if (multa == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(multa).build();
	}

	@GET
	@Transactional
	@Path("/locacao/{id:[0-9][0-9]*}")
	public Response findByLocacao(@PathParam("id") final Integer id) {
		List<Multa> multas = multaDAO.findByLocacao(id);
		if (multas == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(multas).build();
	}
	
	@GET
	@Transactional
	public List<Multa> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Multa> multa = multaDAO.listAll();
		return multa;
	}
	
	@GET
	@Transactional
	@Path("/all")
	public List<Multa> listAll() {
		final List<Multa> multas = multaDAO.listAll();
		return multas;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Multa multa) {
		multa.setIdMulta(id);
		if(multaDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		multaDAO.update(multa);		
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if(multaDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Multa m = new Multa();
		m.setIdMulta(id);
		multaDAO.remove(m);
		return Response.ok().build();
	}
}
