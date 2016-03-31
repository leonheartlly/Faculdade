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

import br.com.unitri.agenciaturismo.model.Companhia;
import br.com.unitri.agenciaturismo.model.Reserva;
import br.com.unitri.agenciaturismo.model.dao.ReservaDao;

@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class ReservaDaoImpl implements ReservaDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final long serialVersionUID = 1L;

	public List<Reserva> listAll() {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT id_reserva_id as id, ");
			hql.append("qtd_compra as quantidade, ");
			hql.append("id_cliente as idCliente, ");
			hql.append("id_pacote as idPacote ");
			hql.append("FROM reserva ");
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("quantidade", IntegerType.INSTANCE);
		    query.addScalar("idCliente", IntegerType.INSTANCE);
		    query.addScalar("idPacote", IntegerType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Reserva.class));
			
			
			List<Reserva> obj = query.list();
			
			return obj;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public Reserva findByID(int id) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT id_reserva_id as id, ");
			hql.append("qtd_compra as quantidade, ");
			hql.append("id_cliente as idCliente, ");
			hql.append("id_pacote as idPacote ");
			hql.append("FROM reserva where id="+id);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("quantidade", IntegerType.INSTANCE);
		    query.addScalar("idCliente", IntegerType.INSTANCE);
		    query.addScalar("idPacote", IntegerType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Reserva.class));
			
			
			List<Reserva> obj = new ArrayList<Reserva>(); 
			obj = query.list();
			Reserva res = obj.get(0);
			return res;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}
	
	public Reserva findByClienteID(int id) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT id_reserva_id as id, ");
			hql.append("qtd_compra as quantidade, ");
			hql.append("id_cliente as idCliente, ");
			hql.append("id_pacote as idPacote ");
			hql.append("FROM reserva where idCliente="+id);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("quantidade", IntegerType.INSTANCE);
		    query.addScalar("idCliente", IntegerType.INSTANCE);
		    query.addScalar("idPacote", IntegerType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Reserva.class));
			
			
			List<Reserva> obj = new ArrayList<Reserva>(); 
			obj = query.list();
			Reserva res = obj.get(0);
			return res;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public void addReserva(Reserva reserva) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO AgenciaTurismo.reserva(qtd_compra, id_cliente, id_pacote) VALUES(:quantidade, :idCliente, :idPacote)")
				.setInteger("quantidade", reserva.getQuantidade())
				.setInteger("idCliente", reserva.getIdCliente())
				.setInteger("idPacote", reserva.getIdPacote());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateReserva(Reserva reserva) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE AgenciaTurismo.reserva SET qtd_compra=:quantidade, id_cliente=:idCliente, id_pacote=:idPacote where id_reserva=:id")
				
				.setInteger("quantidade", reserva.getQuantidade())
				.setInteger("idCliente", reserva.getIdCliente())
				.setInteger("idPacote", reserva.getIdPacote());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void removeReserva(Reserva reserva) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"DELETE from AgenciaTurismo.reserva where id_reserva=:id")
				.setInteger("username", reserva.getId());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
