package org.unitri.ppi2.rest.dao;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.unitri.ppi2.rest.domain.Person;

public class PersonDAO extends GenericDAO<Person, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public PersonDAO(EntityManager entityManager){
		super(Person.class, entityManager);
	}	
	
	
	
	
}
