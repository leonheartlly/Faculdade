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

import org.unitri.ppi2.rest.dao.VeiculoDAO;
import org.unitri.ppi2.rest.domain.Veiculo;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/veiculo")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class VeiculoResource {

	@Inject
	private VeiculoDAO veiculoDAO;

	@POST
	@Transactional
	public Response create(Veiculo veiculo) {
		System.out.println("POST: " + veiculo + " " + new Date());
		veiculoDAO.insert(veiculo);
		return Response.ok(veiculo).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Veiculo veiculo = veiculoDAO.findById(id);
		if (veiculo == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(veiculo).build();
	}

	@GET
	@Transactional
	@Path("/categoria/{preco:[0-9][0-9]*}")
	public Response findByPreco(@PathParam("preco") final Integer preco) {
		List<Veiculo> veiculos = veiculoDAO.findByPreco(preco);
		if (veiculos == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(veiculos).build();
	}
	
	@GET
	@Transactional
	public List<Veiculo> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Veiculo> veiculos = veiculoDAO.listAll();
		return veiculos;
	}

	@GET
	@Transactional
	@Path("/all")
	public List<Veiculo> listAll() {
		final List<Veiculo> veiculos = veiculoDAO.listAll();
		return veiculos;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Veiculo veiculo) {
		veiculo.setIdVeiculo(id);
		if (veiculoDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		veiculoDAO.update(veiculo);
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if (veiculoDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Veiculo v = new Veiculo();
		v.setIdVeiculo(id);
		veiculoDAO.remove(v);
		return Response.ok().build();
	}
}
