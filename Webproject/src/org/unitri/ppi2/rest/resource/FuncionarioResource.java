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

import org.unitri.ppi2.rest.dao.FuncionarioDAO;
import org.unitri.ppi2.rest.domain.Funcionario;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/funcionario")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class FuncionarioResource {

	@Inject
	private FuncionarioDAO funcionarioDAO;

	@POST
	@Transactional
	public Response create(Funcionario funcionario) {
		System.out.println("POST: " + funcionario + " " + new Date());
		funcionarioDAO.insert(funcionario);
		return Response.ok(funcionario).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Funcionario funcionario = funcionarioDAO.findById(id);
		if (funcionario == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(funcionario).build();
	}

	@GET
	@Transactional
	public List<Funcionario> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Funcionario> funcionarios = funcionarioDAO.listAll();
		return funcionarios;
	}

	@GET
	@Transactional
	public List<Funcionario> listAll() {
		final List<Funcionario> funcionarios = funcionarioDAO.listAll();
		return funcionarios;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Funcionario funcionario) {
		funcionario.setIdFuncionario(id);
		if (funcionarioDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		funcionarioDAO.update(funcionario);
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if (funcionarioDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Funcionario p = new Funcionario();
		p.setIdFuncionario(id);
		funcionarioDAO.remove(p);
		return Response.ok().build();
	}
}
