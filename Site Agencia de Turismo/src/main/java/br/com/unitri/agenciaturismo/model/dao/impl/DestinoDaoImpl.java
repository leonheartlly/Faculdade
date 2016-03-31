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
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Destino;
import br.com.unitri.agenciaturismo.model.dao.DestinoDao;

@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class DestinoDaoImpl implements DestinoDao {

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Destino> listAll() {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT id_destino as id, ");
			hql.append("cidadeDestino as cidade, ");
			hql.append("paisDestino as pais, ");
			hql.append("link1 as link1, ");
			hql.append("link2 as link2, ");
			hql.append("link3 as link3, ");
			hql.append("descricao as descricao ");
			hql.append("FROM destino ");
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("cidade", StringType.INSTANCE);
		    query.addScalar("pais", StringType.INSTANCE);
		    query.addScalar("link1", StringType.INSTANCE);
		    query.addScalar("link2", StringType.INSTANCE);
		    query.addScalar("link3",StringType.INSTANCE);
		    query.addScalar("descricao",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Destino.class));
			
			
			List<Destino> obj = query.list();
			
			return obj;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public Destino findByID(int id){
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT id_destino as id, ");
			hql.append("cidadeDestino as cidade, ");
			hql.append("paisDestino as pais, ");
			hql.append("link1 as link1, ");
			hql.append("link2 as link2, ");
			hql.append("link3 as link3, ");
			hql.append("descricao as descricao ");
			hql.append("FROM destino where id="+id);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("cidade", StringType.INSTANCE);
		    query.addScalar("pais", StringType.INSTANCE);
		    query.addScalar("link1", StringType.INSTANCE);
		    query.addScalar("link2", StringType.INSTANCE);
		    query.addScalar("link3",StringType.INSTANCE);
		    query.addScalar("descricao",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Destino.class));
			
			List<Destino> list = new ArrayList<Destino>();
			list = query.list();
			Destino destiny = list.get(0);
			
			return destiny;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Destino findByCity(String city) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT id_destino as id, ");
			hql.append("cidadeDestino as cidade, ");
			hql.append("paisDestino as pais, ");
			hql.append("link1 as link1, ");
			hql.append("link2 as link2, ");
			hql.append("link3 as link3, ");
			hql.append("descricao as descricao ");
			hql.append("FROM destino where cidade="+city);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("cidade", StringType.INSTANCE);
		    query.addScalar("pais", StringType.INSTANCE);
		    query.addScalar("link1", StringType.INSTANCE);
		    query.addScalar("link2", StringType.INSTANCE);
		    query.addScalar("link3",StringType.INSTANCE);
		    query.addScalar("descricao",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Destino.class));
			
			
			List<Destino> obj = new ArrayList<Destino>(); 
			obj = query.list();
			Destino destiny = obj.get(0);
			return destiny;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addDestino(Destino destino) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO AgenciaTurismo.destino(cidadeDestino, paisDestino, link1, link2, link3, descricao) VALUES(:cidade, :pais, :link1, :link2, :link3, :descricao)")
				.setString("cidade", destino.getCidade())
				.setString("pais", destino.getPais())
				.setString("link1", destino.getLink1())
				.setString("link2", destino.getLink2())
				.setString("link3", destino.getLink3())
				.setString("descricao", destino.getDescricao());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateDestino(Destino destino) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE AgenciaTurismo.destino SET  cidadeDestino=:cidade, paisDestino=:pais, link1=:link1, link2=:link2, link3=link3, descricao=:descricao where id_destino=:id")
				.setLong("id", destino.getId())
				.setString("cidade", destino.getCidade())
				.setString("pais", destino.getPais())
				.setString("link1", destino.getLink1())
				.setString("link2", destino.getLink2())
				.setString("link3", destino.getLink3())
				.setString("descricao", destino.getDescricao());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeDestino(Destino destino) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(
				"DELETE from AgenciaTurismo.destino where id_destino=:id")
				.setLong("id", destino.getId());
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
