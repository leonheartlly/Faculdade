package br.com.unitri.agenciaturismo.model.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Users;
import br.com.unitri.agenciaturismo.model.dao.UsersDao;

@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class UsersDaoImpl implements UsersDao{

	 @Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Users> listAll() {
		 try {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT username as username, ");
		hql.append("password as password, ");
		hql.append("enabled as enabled ");
		hql.append("FROM users ");
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
		
		query.addScalar("username", StringType.INSTANCE);
		query.addScalar("password", StringType.INSTANCE);
	    query.addScalar("enabled", BooleanType.INSTANCE);

	    query.setResultTransformer(Transformers.aliasToBean(Users.class));
		
		
		List<Users> obj = query.list();
		
		return obj;
		
	} catch (HibernateException e) {
		e.printStackTrace();
	}
		return null;
	}

	public Users findByUsername(String username) {
		
		return null;
	}


	public void addUsers(Users users) {

		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO AgenciaTurismo.users(username,password,enabled) VALUES(:username,:password,:enabled)")
				.setString("username", users.getUsername())
				.setString("password", users.getPassword())
				.setBoolean("enabled", users.isEnabled());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateUsers(Users users) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE AgenciaTurismo.users SET password=:password, enabled=:enabled where username=:username")
				.setString("username", users.getUsername())
				.setString("password", users.getPassword())
				.setBoolean("enabled", users.isEnabled());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public void removeUsers(Users users) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"DELETE from AgenciaTurismo.users where username=:username")
				.setString("username", users.getUsername());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
