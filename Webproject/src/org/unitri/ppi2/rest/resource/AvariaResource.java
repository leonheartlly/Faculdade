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

import org.unitri.ppi2.rest.dao.AvariaDAO;
import org.unitri.ppi2.rest.domain.Avaria;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/avaria")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class AvariaResource {

	@Inject
	private AvariaDAO avariaDAO;

	@POST
	@Transactional
	public Response create(Avaria avaria) {
		System.out.println("POST: " + avaria + " " + new Date());
		avariaDAO.insert(avaria);
		return Response.ok(avaria).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Avaria avaria = avariaDAO.findById(id);
		if (avaria == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(avaria).build();
	}

	@GET
	@Transactional
	public List<Avaria> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Avaria> avarias = avariaDAO.listAll();
		return avarias;
	}

	@GET
	@Transactional
	public List<Avaria> listAll() {
		final List<Avaria> avarias = avariaDAO.listAll();
		return avarias;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Avaria avaria) {
		avaria.setIdAvaria(id);
		if (avariaDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		avariaDAO.update(avaria);
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if (avariaDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Avaria p = new Avaria();
		p.setIdAvaria(id);
		avariaDAO.remove(p);
		return Response.ok().build();
	}
}
