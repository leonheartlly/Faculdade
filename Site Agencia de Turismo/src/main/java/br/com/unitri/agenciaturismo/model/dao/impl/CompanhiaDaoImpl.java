package br.com.unitri.agenciaturismo.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Cliente;
import br.com.unitri.agenciaturismo.model.Companhia;
import br.com.unitri.agenciaturismo.model.dao.CompanhiaDao;


@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class CompanhiaDaoImpl implements CompanhiaDao {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Companhia> listAll() {
		try {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT companhia_id as id, ");
		hql.append("nome_companhia as nome, ");
		hql.append("cnpj as cnpj, ");
		hql.append("ddd as ddd, ");
		hql.append("telefone as fone, ");
		hql.append("tipoCompanhia as tipoCompanhia, ");
		hql.append("FROM companhia ");
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
		
		query.addScalar("id", LongType.INSTANCE);
		query.addScalar("nome", StringType.INSTANCE);
	    query.addScalar("cnpj", StringType.INSTANCE);
	    query.addScalar("ddd", IntegerType.INSTANCE);
	    query.addScalar("fone",StringType.INSTANCE);
	    query.addScalar("tipoCompanhia",StringType.INSTANCE);
	    
	    query.setResultTransformer(Transformers.aliasToBean(Companhia.class));
		
		
		List<Companhia> obj = query.list();
		
		return obj;
		
	} catch (HibernateException e) {
		e.printStackTrace();
	}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Companhia findByID(int id) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT companhia_id as id, ");
			hql.append("nome_companhia as nome, ");
			hql.append("cnpj as cnpj, ");
			hql.append("ddd as ddd, ");
			hql.append("telefone as fone, ");
			hql.append("tipoCompanhia as tipoCompanhia, ");
			hql.append("FROM companhia where id="+id);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", LongType.INSTANCE);
			query.addScalar("nome", StringType.INSTANCE);
		    query.addScalar("cnpj", StringType.INSTANCE);
		    query.addScalar("ddd", IntegerType.INSTANCE);
		    query.addScalar("fone",StringType.INSTANCE);
		    query.addScalar("tipoCompanhia",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Companhia.class));
			
		    List<Companhia> list = new ArrayList<Companhia>();
		    list = query.list();
			Companhia comp = list.get(0);
			
			return comp;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}
	@SuppressWarnings("unchecked")
	public Companhia findByName(String name) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT companhia_id as id, ");
			hql.append("nome_companhia as nome, ");
			hql.append("cnpj as cnpj, ");
			hql.append("ddd as ddd,");
			hql.append("telefone as fone,");
			hql.append("tipoCompanhia as tipoCompanhia,");
			hql.append("FROM companhia where nome="+name);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", LongType.INSTANCE);
			query.addScalar("nome", StringType.INSTANCE);
		    query.addScalar("cnpj", StringType.INSTANCE);
		    query.addScalar("ddd", IntegerType.INSTANCE);
		    query.addScalar("fone",StringType.INSTANCE);
		    query.addScalar("tipoCompanhia",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Companhia.class));
			
		    List<Companhia> list = new ArrayList<Companhia>();
		    list = query.list();
			Companhia comp = list.get(0);
			
			return comp;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public void addCompanhia(Companhia companhia) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO AgenciaTurismo.companhia(nome_companhia, cnpj, ddd, telefone, tipoCompanhia) VALUES(:nome, :cnpj, :ddd, :fone, :tipoCompanhia)")
				.setString("nome", companhia.getNome())
				.setString("cnpj", companhia.getCnpj())
				.setString("ddd", companhia.getDdd())
				.setString("fone", companhia.getFone())
				.setString("tipoCompanhia", companhia.getTipoCompanhia());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateCompanhia(Companhia companhia) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE AgenciaTurismo.companhia SET  nome_companhia=:nome, cnpj=:cnpj, ddd=:ddd, telefone=:telefone, tipoCompanhia=:tipoCompanhia where companhia_id=:id")
				.setLong("id", companhia.getId())
				.setString("nome", companhia.getNome())
				.setString("cnpj", companhia.getCnpj())
				.setString("ddd", companhia.getDdd())
				.setString("telefone", companhia.getFone())
				.setString("tipoCompanhia", companhia.getTipoCompanhia());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeCompanhia(Companhia companhia) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(
				"DELETE from AgenciaTurismo.companhia where companhia_id=:id")
				.setLong("id", companhia.getId());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
