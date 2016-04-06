package org.unitri.ppi2.rest.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFac{

	private static EntityManagerFactory emf;

	@Produces
	@RequestScoped
	public EntityManager getManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("Webproject");
		}
		return emf.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		try {
			manager.close();
		}catch(Exception ex) {
		}
	}	
}
