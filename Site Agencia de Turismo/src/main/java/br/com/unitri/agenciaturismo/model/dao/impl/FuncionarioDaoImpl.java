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
import br.com.unitri.agenciaturismo.model.Funcionario;
import br.com.unitri.agenciaturismo.model.dao.FuncionarioDao;

@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class FuncionarioDaoImpl implements FuncionarioDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final long serialVersionUID = 1L;

	public List<Funcionario> listAll() {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT funcionario_id as id, ");
			hql.append("nome as nome, ");
			hql.append("idade as idade, ");
			hql.append("cpf as cpf, ");
			hql.append("email as email, ");
			hql.append("sexo as sexo, ");
			hql.append("telefone as fone, ");
			hql.append("ddd as ddd, ");
			hql.append("endereco as endereco, ");
			hql.append("bairro as bairro, ");
			hql.append("estado as estado, ");
			hql.append("cep as cep, ");
			hql.append("pais as pais, ");
			hql.append("username as username ");
			hql.append("FROM funcionario ");
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", LongType.INSTANCE);
			query.addScalar("nome", StringType.INSTANCE);
		    query.addScalar("idade", StringType.INSTANCE);
		    query.addScalar("cpf", StringType.INSTANCE);
		    query.addScalar("email", StringType.INSTANCE);
		    query.addScalar("sexo", StringType.INSTANCE);
		    query.addScalar("fone",StringType.INSTANCE);
		    query.addScalar("ddd", StringType.INSTANCE);
		    query.addScalar("endereco",StringType.INSTANCE);
		    query.addScalar("bairro",StringType.INSTANCE);
		    query.addScalar("estado",StringType.INSTANCE);
		    query.addScalar("cep",StringType.INSTANCE);
		    query.addScalar("pais",StringType.INSTANCE);
		    query.addScalar("username",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Funcionario.class));
			
			
			List<Funcionario> obj = query.list();
			
			return obj;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public Funcionario findByID(int id) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT funcionario_id as id, ");
			hql.append("nome as nome, ");
			hql.append("idade as idade, ");
			hql.append("cpf as cpf, ");
			hql.append("email as email, ");
			hql.append("sexo as sexo, ");
			hql.append("telefone as fone, ");
			hql.append("ddd as ddd, ");
			hql.append("endereco as endereco, ");
			hql.append("bairro as bairro, ");
			hql.append("estado as estado, ");
			hql.append("cep as cep, ");
			hql.append("pais as pais, ");
			hql.append("username as username ");
			hql.append("FROM funcionario where id="+id);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", LongType.INSTANCE);
			query.addScalar("nome", StringType.INSTANCE);
		    query.addScalar("idade", StringType.INSTANCE);
		    query.addScalar("cpf", StringType.INSTANCE);
		    query.addScalar("email", StringType.INSTANCE);
		    query.addScalar("sexo", StringType.INSTANCE);
		    query.addScalar("fone",StringType.INSTANCE);
		    query.addScalar("ddd", StringType.INSTANCE);
		    query.addScalar("endereco",StringType.INSTANCE);
		    query.addScalar("bairro",StringType.INSTANCE);
		    query.addScalar("estado",StringType.INSTANCE);
		    query.addScalar("cep",StringType.INSTANCE);
		    query.addScalar("pais",StringType.INSTANCE);
		    query.addScalar("username",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Funcionario.class));
			
			
			List<Funcionario> obj = new ArrayList<Funcionario>(); 
			obj=query.list();
			Funcionario func = obj.get(0);
			return func;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public Funcionario findByName(String name) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT funcionario_id as id, ");
			hql.append("nome as nome, ");
			hql.append("idade as idade, ");
			hql.append("cpf as cpf, ");
			hql.append("email as email, ");
			hql.append("sexo as sexo, ");
			hql.append("telefone as fone, ");
			hql.append("ddd as ddd, ");
			hql.append("endereco as endereco, ");
			hql.append("bairro as bairro, ");
			hql.append("estado as estado, ");
			hql.append("cep as cep, ");
			hql.append("pais as pais, ");
			hql.append("username as username ");
			hql.append("FROM funcionario where nome="+name);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", LongType.INSTANCE);
			query.addScalar("nome", StringType.INSTANCE);
		    query.addScalar("idade", StringType.INSTANCE);
		    query.addScalar("cpf", StringType.INSTANCE);
		    query.addScalar("email", StringType.INSTANCE);
		    query.addScalar("sexo", StringType.INSTANCE);
		    query.addScalar("fone",StringType.INSTANCE);
		    query.addScalar("ddd", StringType.INSTANCE);
		    query.addScalar("endereco",StringType.INSTANCE);
		    query.addScalar("bairro",StringType.INSTANCE);
		    query.addScalar("estado",StringType.INSTANCE);
		    query.addScalar("cep",StringType.INSTANCE);
		    query.addScalar("pais",StringType.INSTANCE);
		    query.addScalar("username",StringType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Funcionario.class));
			
			
		    List<Funcionario> obj = new ArrayList<Funcionario>(); 
			obj=query.list();
			Funcionario func = obj.get(0);
			return func;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public void addFuncionario(Funcionario funcionario) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"INSERT INTO AgenciaTurismo.funcionario(nome, idade, cep, cpf, email, sexo, endereco, bairro, estado, pais, telefone, ddd, username) VALUES(:nome, :idade, :cep, :cpf, :email, :sexo, :endereco, :bairro, :estado, :pais, :fone, :ddd, :username)")
				.setString("username", funcionario.getUsername())
				.setString("nome", funcionario.getNome())
				.setString("idade", funcionario.getIdade())
				.setString("cep", funcionario.getCep())
				.setString("cpf", funcionario.getCpf())
				.setString("email", funcionario.getEmail())
				.setString("sexo", funcionario.getSexo())
				.setString("endereco", funcionario.getEndereco())
				.setString("bairro", funcionario.getBairro())
				.setString("estado", funcionario.getEstado())
				.setString("pais", funcionario.getPais())
				.setString("fone", funcionario.getFone())
				.setString("ddd", funcionario.getDdd());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateFuncionario(Funcionario funcionario) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"UPDATE AgenciaTurismo.funcionario SET nome=:nome, cep=:cep, cpf=:cpf, email=:email, sexo=:sexo, endereco=:endereco, bairro=:bairro, estado=:estado, idade=:idade, pais=:pais, telefone=:tel, ddd=:ddd where username=:username")
				
				.setString("nome", funcionario.getNome())
				.setString("cep", funcionario.getCep())
				.setString("cpf", funcionario.getCpf())
				.setString("email", funcionario.getEmail())
				.setString("sexo", funcionario.getSexo())
				.setString("endereco", funcionario.getEndereco())
				.setString("bairro", funcionario.getBairro())
				.setString("estado", funcionario.getEstado())
				.setString("idade", funcionario.getIdade())
				.setString("pais", funcionario.getPais())
				.setString("fone", funcionario.getFone())
				.setString("ddd", funcionario.getDdd())
				.setString("username", funcionario.getUsername());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void removeFuncionario(Funcionario funcionario) {
		Session session = null;
		session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createSQLQuery(
						"DELETE from AgenciaTurismo.funcionario where username=:username")
				.setString("username", funcionario.getUsername());
		try {
			int updated = query.executeUpdate();
			System.out.println(updated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
