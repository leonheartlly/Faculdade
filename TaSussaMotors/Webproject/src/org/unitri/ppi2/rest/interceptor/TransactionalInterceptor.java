package org.unitri.ppi2.rest.interceptor;

import java.io.Serializable;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object intercept(InvocationContext context) {
		Object resultado = null;
		try {
			entityManager.getTransaction().begin();
			resultado = context.proceed();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			try {
				entityManager.getTransaction().rollback();
			} catch(Exception ex){}
			e.printStackTrace();
		}
		return resultado;
	}
}
