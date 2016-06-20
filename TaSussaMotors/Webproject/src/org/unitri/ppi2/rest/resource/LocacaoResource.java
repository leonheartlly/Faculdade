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

import org.unitri.ppi2.rest.dao.LocacaoDAO;
import org.unitri.ppi2.rest.domain.Locacao;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/locacao")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class LocacaoResource {

	@Inject
	private LocacaoDAO locacaoDAO;

	@POST
	@Transactional
	public Response create(Locacao locacao) {
		System.out.println("POST: " + locacao + " " + new Date());
		locacaoDAO.insert(locacao);
		return Response.ok(locacao).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Locacao locacao = locacaoDAO.findById(id);
		if (locacao == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(locacao).build();
	}

	@GET
	@Transactional
	public List<Locacao> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Locacao> locacaos = locacaoDAO.listAll();
		return locacaos;
	}

	@GET
	@Transactional
	public List<Locacao> listAll() {
		final List<Locacao> locacaos = locacaoDAO.listAll();
		return locacaos;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Locacao locacao) {
		locacao.setIdLocacao(id);
		if (locacaoDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		locacaoDAO.update(locacao);
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if (locacaoDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Locacao p = new Locacao();
		p.setIdLocacao(id);
		locacaoDAO.remove(p);
		return Response.ok().build();
	}
	
	@GET
	@Transactional
	@Path("/mes/{mes:[0-9][0-9]*}")
	public Response findByMes(@PathParam("mes") Integer mes) {
		if(mes < 0 || mes > 12){
			return Response.status(Status.NOT_FOUND).build();
		}
		List<Locacao> locacaos = locacaoDAO.pesquisarPorMes(mes);
		 return Response.ok(locacaos).build();
	}
	
	@GET
	@Transactional
	@Path("/veiculo/{id:[0-9][0-9]*}")
	public List<Locacao> findByVeiculo(@PathParam("id") final Integer id) {
		List<Locacao> locacaos = locacaoDAO.pesquisarPorVeiculo(id);
		return locacaos;
	}
	
	@GET
	@Transactional
	@Path("/funcionario/{id:[0-9][0-9]*}")
	public List<Locacao> findByFuncionario(@PathParam("id") final Integer id) {
		List<Locacao> locacaos = locacaoDAO.pesquisarPorFuncionario(id);
		return locacaos;
	}
}
