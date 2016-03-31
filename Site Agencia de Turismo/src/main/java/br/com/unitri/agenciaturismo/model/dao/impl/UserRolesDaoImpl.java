package br.com.unitri.agenciaturismo.model.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.UserRoles;
import br.com.unitri.agenciaturismo.model.dao.UserRolesDao;


@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class UserRolesDaoImpl implements UserRolesDao {
	 @Autowired
		private SessionFactory sessionFactory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add(UserRoles userRoles) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO AgenciaTurismo.user_roles (username,ROLE) VALUES(:username,:role)")
				.setString("username", userRoles.getUsername())
				.setString("role", userRoles.getRole());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void update(UserRoles userRoles) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE AgenciaTurismo.user_roles SET  ROLE=:role where username=:username")
				.setString("username", userRoles.getUsername())
				.setString("role", userRoles.getRole());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void remove(UserRoles userRoles) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"DELETE from AgenciaTurismo.user_roles where username=:username")
				.setString("username", userRoles.getUsername());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
