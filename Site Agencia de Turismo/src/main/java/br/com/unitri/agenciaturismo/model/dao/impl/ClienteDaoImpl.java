package br.com.unitri.agenciaturismo.model.dao.impl;

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
import br.com.unitri.agenciaturismo.model.dao.ClienteDao;


@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class ClienteDaoImpl implements ClienteDao{

	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Cliente> listAll() {
		 try {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT id_cliente as id_cliente, ");
		hql.append("nome as nome, ");
		hql.append("idade as idade, ");
		hql.append("cpf as cpf, ");
		hql.append("email as email, ");
		hql.append("telefone as tel, ");
		hql.append("endereco as endereco, ");
		hql.append("bairro as bairro, ");
		hql.append("estado as estado, ");
		hql.append("cep as cep, ");
		hql.append("pais as pais, ");
		hql.append("cidade as cidade, ");
		hql.append("numero as numero, ");
		hql.append("data as data, ");
		hql.append("username as username ");
		hql.append("FROM cliente ");
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
		
		query.addScalar("id_cliente", LongType.INSTANCE);
		query.addScalar("nome", StringType.INSTANCE);
	    query.addScalar("idade", IntegerType.INSTANCE);
	    query.addScalar("cpf", StringType.INSTANCE);
	    query.addScalar("email", StringType.INSTANCE);
	    query.addScalar("tel",StringType.INSTANCE);
	    query.addScalar("endereco",StringType.INSTANCE);
	    query.addScalar("bairro",StringType.INSTANCE);
	    query.addScalar("estado",StringType.INSTANCE);
	    query.addScalar("cep",StringType.INSTANCE);
	    query.addScalar("pais",StringType.INSTANCE);
	    query.addScalar("cidade",StringType.INSTANCE);
	    query.addScalar("numero",StringType.INSTANCE);
	    query.addScalar("data",StringType.INSTANCE);
	    query.addScalar("username",StringType.INSTANCE);
	    
	    query.setResultTransformer(Transformers.aliasToBean(Cliente.class));
		
		
		List<Cliente> obj = query.list();
				
		return obj;
		
	} catch (HibernateException e) {
		e.printStackTrace();
	}
		return null;
	}

	public Cliente findByID(int id) {
		 try {
				StringBuilder hql = new StringBuilder();
				
				hql.append("SELECT id_cliente as id_cliente, ");
				hql.append("nome as nome, ");
				hql.append("idade as idade, ");
				hql.append("cpf as cpf, ");
				hql.append("email as email,");
				hql.append("telefone as tel, ");
				hql.append("endereco as endereco, ");
				hql.append("bairro as bairro, ");
				hql.append("estado as estado, ");
				hql.append("cep as cep, ");
				hql.append("pais as pais, ");
				hql.append("cidade as cidade, ");
				hql.append("numero as numero, ");
				hql.append("data as data, ");
				hql.append("username as username ");
				hql.append("FROM cliente where id_cliente="+id);
				
				SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
				
				query.addScalar("id_cliente", LongType.INSTANCE);
				query.addScalar("nome", StringType.INSTANCE);
			    query.addScalar("idade", IntegerType.INSTANCE);
			    query.addScalar("cpf", StringType.INSTANCE);
			    query.addScalar("email", StringType.INSTANCE);
			    query.addScalar("tel",StringType.INSTANCE);
			    query.addScalar("endereco",StringType.INSTANCE);
			    query.addScalar("bairro",StringType.INSTANCE);
			    query.addScalar("estado",StringType.INSTANCE);
			    query.addScalar("cep",StringType.INSTANCE);
			    query.addScalar("pais",StringType.INSTANCE);
			    query.addScalar("cidade",StringType.INSTANCE);
			    query.addScalar("numero",StringType.INSTANCE);
			    query.addScalar("data",StringType.INSTANCE);
			    query.addScalar("username",StringType.INSTANCE);
			    
			    query.setResultTransformer(Transformers.aliasToBean(Cliente.class));
				
				
				List<Cliente> obj = query.list();
				Cliente scli = obj.get(0);
				return scli;
				
			} catch (HibernateException e) {
				e.printStackTrace();
			}
				return null;
	}

	public Cliente findByName(String name) {
		 try {
				StringBuilder hql = new StringBuilder();
				
				hql.append("SELECT id_cliente as id_cliente, ");
				hql.append("nome as nome, ");
				hql.append("idade as idade, ");
				hql.append("cpf as cpf, ");
				hql.append("email as email, ");
				hql.append("telefone as tel, ");
				hql.append("endereco as endereco, ");
				hql.append("bairro as bairro, ");
				hql.append("estado as estado, ");
				hql.append("cep as cep, ");
				hql.append("pais as pais, ");
				hql.append("cidade as cidade, ");
				hql.append("numero as numero, ");
				hql.append("data as data, ");
				hql.append("username as username ");
				hql.append("FROM cliente where nome="+name);
				
				SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
				
				query.addScalar("id_cliente", LongType.INSTANCE);
				query.addScalar("nome", StringType.INSTANCE);
			    query.addScalar("idade", IntegerType.INSTANCE);
			    query.addScalar("cpf", StringType.INSTANCE);
			    query.addScalar("email", IntegerType.INSTANCE);
			    query.addScalar("tel",StringType.INSTANCE);
			    query.addScalar("endereco",StringType.INSTANCE);
			    query.addScalar("bairro",StringType.INSTANCE);
			    query.addScalar("estado",StringType.INSTANCE);
			    query.addScalar("cep",StringType.INSTANCE);
			    query.addScalar("pais",StringType.INSTANCE);
			    query.addScalar("cidade",StringType.INSTANCE);
			    query.addScalar("numero",StringType.INSTANCE);
			    query.addScalar("data",StringType.INSTANCE);
			    query.addScalar("username",StringType.INSTANCE);
			    
			    query.setResultTransformer(Transformers.aliasToBean(Cliente.class));
				
				
				List<Cliente> obj = query.list();
				Cliente scli = obj.get(0);
				return scli;
				
			} catch (HibernateException e) {
				e.printStackTrace();
			}
				return null;
	}

	

	public void addPessoa(Cliente pessoa) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO cliente(nome, cep, cpf, email, endereco, bairro, estado, idade, pais, telefone, cidade, numero, data, username) VALUES(:nome, :cep, :cpf, :email, :endereco, :bairro, :estado, :idade, :pais, :tel, :cidade, :numero, :data, :username)")
				.setString("username", pessoa.getUsername())
				.setString("nome", pessoa.getNome())
				.setString("cep", pessoa.getCep())
				.setString("cpf", pessoa.getCpf())
				.setString("email", pessoa.getEmail())
				.setString("endereco", pessoa.getEndereco())
				.setString("bairro", pessoa.getBairro())
				.setString("estado", pessoa.getEstado())
				.setInteger("idade", pessoa.getIdade())
				.setString("pais", pessoa.getPais())
				.setString("tel", pessoa.getTel())
				.setString("cidade", pessoa.getCidade())
				.setString("numero", pessoa.getNumero())
				.setString("data", pessoa.getData());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updatePessoa(Cliente pessoa) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE cliente SET nome=:nome, cep=:cep, cpf=:cpf, email=:email, endereco=:endereco, bairro=:bairro, estado=:estado, idade=:idade, pais=:pais, telefone=:tel, cidade=:cidade, numero=:numero, data=:data where username=:username")
				.setString("username", pessoa.getUsername())
				.setString("nome", pessoa.getNome())
				.setString("cep", pessoa.getCep())
				.setString("cpf", pessoa.getCpf())
				.setString("email", pessoa.getEmail())
				.setString("endereco", pessoa.getEndereco())
				.setString("bairro", pessoa.getBairro())
				.setString("estado", pessoa.getEstado())
				.setInteger("idade", pessoa.getIdade())
				.setString("pais", pessoa.getPais())
				.setString("tel", pessoa.getTel())
				.setString("cidade", pessoa.getCidade())
				.setString("numero", pessoa.getNumero())
				.setString("data", pessoa.getData());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void removePessoa(Cliente pessoa) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"DELETE from cliente where username=:username")
				.setString("username", pessoa.getUsername());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
