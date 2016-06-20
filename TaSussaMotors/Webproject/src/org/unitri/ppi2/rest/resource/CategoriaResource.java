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

import org.unitri.ppi2.rest.dao.CategoriaDAO;
import org.unitri.ppi2.rest.domain.Categoria;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CategoriaResource {

	@Inject
	private CategoriaDAO categoriaDAO;

	@POST
	@Transactional
	public Response create(Categoria categoria) {
		System.out.println("POST: " + categoria + " " + new Date());
		categoriaDAO.insert(categoria);
		return Response.ok(categoria).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Categoria categoria = categoriaDAO.findById(id);
		if (categoria == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(categoria).build();
	}

	@GET
	@Transactional
	public List<Categoria> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Categoria> categorias = categoriaDAO.listAll();
		return categorias;
	}
	
	@GET
	@Transactional
	public List<Categoria> listAll() {
		final List<Categoria> categorias = categoriaDAO.listAll();
		return categorias;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Categoria categoria) {
		categoria.setIdCategoria(id);
		if(categoriaDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		categoriaDAO.update(categoria);		
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if(categoriaDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Categoria p = new Categoria();
		p.setIdCategoria(id);
		categoriaDAO.remove(p);
		return Response.ok().build();
	}
}
