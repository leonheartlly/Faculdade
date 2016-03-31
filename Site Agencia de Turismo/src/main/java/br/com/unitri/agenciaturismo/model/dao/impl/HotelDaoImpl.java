package br.com.unitri.agenciaturismo.model.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Cliente;
import br.com.unitri.agenciaturismo.model.Companhia;
import br.com.unitri.agenciaturismo.model.Hotel;
import br.com.unitri.agenciaturismo.model.dao.HotelDao;

@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class HotelDaoImpl implements HotelDao{

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Hotel> listAll() {
		 try {
				StringBuilder hql = new StringBuilder();
				
				hql.append("SELECT id_hotel as id, ");
				hql.append("nome as nome, ");
				hql.append("cnpj as cnpj, ");
				hql.append("qtdestrelas as estrelas, ");
				hql.append("preco as preco, ");
				hql.append("ddd as ddd, ");
				hql.append("telefone as fone, ");
				hql.append("qtd_quarto as quantidadeQuartos, ");
				hql.append("pais as pais, ");
				hql.append("linkTitle as linkTitle, ");
				hql.append("link1 as link1, ");
				hql.append("link2 as link2, ");
				hql.append("link3 as link3, ");
				hql.append("descricao as descricao, ");
				hql.append("cidade as cidade ");
				hql.append("FROM hotel ");
				
				SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
				
				query.addScalar("id", IntegerType.INSTANCE);
				query.addScalar("nome", StringType.INSTANCE);
			    query.addScalar("cnpj", StringType.INSTANCE);
			    query.addScalar("estrelas", StringType.INSTANCE);
			    query.addScalar("preco", FloatType.INSTANCE);
			    query.addScalar("ddd",StringType.INSTANCE);
			    query.addScalar("fone",StringType.INSTANCE);
			    query.addScalar("quantidadeQuartos",IntegerType.INSTANCE);
			    query.addScalar("pais",StringType.INSTANCE);
			    query.addScalar("linkTitle",StringType.INSTANCE);
			    query.addScalar("link1",StringType.INSTANCE);
			    query.addScalar("link2",StringType.INSTANCE);
			    query.addScalar("link3",StringType.INSTANCE);
			    query.addScalar("descricao",StringType.INSTANCE);
			    query.addScalar("cidade",StringType.INSTANCE);
			    
			    query.setResultTransformer(Transformers.aliasToBean(Hotel.class));
				
				
				List<Hotel> obj = query.list();
				
				return obj;
				
			} catch (HibernateException e) {
				e.printStackTrace();
			}
				return null;
	}

	public Hotel findByCity(String cidade) {
		 try {
				StringBuilder hql = new StringBuilder();
				
				hql.append("SELECT id_hotel as id, ");
				hql.append("nome as nome, ");
				hql.append("cnpj as cnpj, ");
				hql.append("qtdestrelas as estrelas, ");
				hql.append("preco as preco, ");
				hql.append("ddd as ddd, ");
				hql.append("telefone as fone, ");
				hql.append("qtd_quarto as quantidadeQuartos, ");
				hql.append("pais as pais, ");
				hql.append("linkTitle as linkTitle, ");
				hql.append("link1 as link1, ");
				hql.append("link2 as link2, ");
				hql.append("link3 as link3, ");
				hql.append("descricao as descricao, ");
				hql.append("cidade as cidade ");
				hql.append("FROM hotel where cidade="+cidade);
				
				SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
				
				query.addScalar("id", IntegerType.INSTANCE);
				query.addScalar("nome", StringType.INSTANCE);
			    query.addScalar("cnpj", StringType.INSTANCE);
			    query.addScalar("estrelas", StringType.INSTANCE);
			    query.addScalar("preco", FloatType.INSTANCE);
			    query.addScalar("ddd",StringType.INSTANCE);
			    query.addScalar("fone",StringType.INSTANCE);
			    query.addScalar("quantidadeQuartos",IntegerType.INSTANCE);
			    query.addScalar("pais",StringType.INSTANCE);
			    query.addScalar("linkTitle",StringType.INSTANCE);
			    query.addScalar("link1",StringType.INSTANCE);
			    query.addScalar("link2",StringType.INSTANCE);
			    query.addScalar("link3",StringType.INSTANCE);
			    query.addScalar("descricao",StringType.INSTANCE);
			    query.addScalar("cidade",StringType.INSTANCE);
			    
			    query.setResultTransformer(Transformers.aliasToBean(Hotel.class));
				
				
			    List<Hotel> obj = query.list();
				Hotel sHotel = obj.get(0);
				return sHotel;
				
			} catch (HibernateException e) {
				e.printStackTrace();
			}
				return null;
	}

	public Hotel findByName(String name) {
		 try {
				StringBuilder hql = new StringBuilder();
				
				hql.append("SELECT id_hotel as id, ");
				hql.append("nome as nome, ");
				hql.append("cnpj as cnpj, ");
				hql.append("qtdestrelas as estrelas, ");
				hql.append("preco as preco, ");
				hql.append("ddd as ddd, ");
				hql.append("telefone as fone, ");
				hql.append("qtd_quarto as quantidadeQuartos, ");
				hql.append("pais as pais, ");
				hql.append("linkTitle as linkTitle, ");
				hql.append("link1 as link1, ");
				hql.append("link2 as link2, ");
				hql.append("link3 as link3, ");
				hql.append("descricao as descricao, ");
				hql.append("cidade as cidade ");
				hql.append("FROM hotel where nome="+name);
				
				SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
				
				query.addScalar("id", IntegerType.INSTANCE);
				query.addScalar("nome", StringType.INSTANCE);
			    query.addScalar("cnpj", StringType.INSTANCE);
			    query.addScalar("estrelas", StringType.INSTANCE);
			    query.addScalar("preco", FloatType.INSTANCE);
			    query.addScalar("ddd",StringType.INSTANCE);
			    query.addScalar("fone",StringType.INSTANCE);
			    query.addScalar("quantidadeQuartos",IntegerType.INSTANCE);
			    query.addScalar("pais",StringType.INSTANCE);
			    query.addScalar("linkTitle",StringType.INSTANCE);
			    query.addScalar("link1",StringType.INSTANCE);
			    query.addScalar("link2",StringType.INSTANCE);
			    query.addScalar("link3",StringType.INSTANCE);
			    query.addScalar("descricao",StringType.INSTANCE);
			    query.addScalar("cidade",StringType.INSTANCE);
			    
			    query.setResultTransformer(Transformers.aliasToBean(Hotel.class));
				
				
			    return (Hotel)query.uniqueResult();
//				Hotel sHotel = obj.get(0);
//				return sHotel;
				
			} catch (HibernateException e) {
				e.printStackTrace();
			}
				return null;
	}

	public void addHotel(Hotel hotel) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO AgenciaTurismo.hotel(nome, cnpj, qtdestrelas, preco, ddd, telefone, qtd_quarto, pais, linkTitle, link1, link2, link3, descricao, cidade) VALUES(:nome, :cnpj, :estrelas, :preco, :ddd, :fone, :quantidadeQuartos, :pais, :linkTitle, :link1, :link2, :link3, :descricao, :cidade)")
				.setString("nome", hotel.getNome())
				.setString("cnpj", hotel.getCnpj())
				.setString("estrelas", hotel.getEstrelas())
				.setFloat("preco", hotel.getPreco())
				.setString("ddd", hotel.getDdd())
				.setString("fone", hotel.getFone())
				.setInteger("quantidadeQuartos", hotel.getQuantidadeQuartos())
				.setString("pais", hotel.getPais())
				.setString("linkTitle", hotel.getLinkTitle())
				.setString("link1", hotel.getLink1())
				.setString("link2", hotel.getLink2())
				.setString("link3", hotel.getLink3())
				.setString("descricao", hotel.getDescricao())
				.setString("cidade", hotel.getCidade());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateHotel(Hotel hotel) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE AgenciaTurismo.hotel SET nome=:nome, cnpj=:cnpj, qtdestrelas=:estrelas, preco=:preco, ddd=:ddd, telefone=:fone, qtd_quartos=:quantidadeQuartos, pais=:pais, linkTitle=:linkTitle, link1=:link1, link2=:link2, link3=:link3, descricao=:descricao, cidade=:cidade where id_hotel=:id")
				
				.setInteger("id", hotel.getId())		
				.setString("nome", hotel.getNome())
				.setString("cnpj", hotel.getCnpj())
				.setString("estrelas", hotel.getEstrelas())
				.setFloat("preco", hotel.getPreco())
				.setString("ddd", hotel.getDdd())
				.setString("fone", hotel.getFone())
				.setInteger("quantidadeQuartos", hotel.getQuantidadeQuartos())
				.setString("pais", hotel.getPais())
				.setString("linkTitle", hotel.getLinkTitle())
				.setString("link1", hotel.getLink1())
				.setString("link2", hotel.getLink2())
				.setString("link3", hotel.getLink3())
				.setString("descricao", hotel.getDescricao())
				.setString("cidade", hotel.getCidade());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void removeHotel(Hotel hotel) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"DELETE from AgenciaTurismo.hotel where id_hotel=:id")
				.setInteger("username", hotel.getId());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
