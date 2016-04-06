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

import org.unitri.ppi2.rest.dao.PersonDAO;
import org.unitri.ppi2.rest.domain.Person;
import org.unitri.ppi2.rest.interceptor.Transactional;

@RequestScoped
@Path("/person")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class PersonResource {

	@Inject
	private PersonDAO personDAO;

	@POST
	@Transactional
	public Response create(Person person) {
		System.out.println("POST: " + person + " " + new Date());
		personDAO.insert(person);
		return Response.ok(person).build();
	}

	@GET
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Integer id) {
		Person person = personDAO.findById(id);
		if (person == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(person).build();
	}

	@GET
	@Transactional
	public List<Person> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<Person> persons = personDAO.listAll();
		return persons;
	}
	
	@GET
	@Transactional
	public List<Person> listAll() {
		final List<Person> persons = personDAO.listAll();
		return persons;
	}

	@PUT
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Integer id, final Person person) {
		person.setId(id);
		if(personDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		personDAO.update(person);		
		return Response.ok().build();
	}

	@DELETE
	@Transactional
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Integer id) {
		if(personDAO.findById(id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Person p = new Person();
		p.setId(id);
		personDAO.remove(p);
		return Response.ok().build();
	}
}
