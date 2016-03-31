package br.com.unitri.agenciaturismo.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.unitri.agenciaturismo.model.Pacote;
import br.com.unitri.agenciaturismo.model.dao.PacoteDao;

@Repository
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class PacoteDaoImpl implements PacoteDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Pacote> listAll() {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT pacote_id as id, ");
			hql.append("nome_pacote as nomePacote, ");
			hql.append("cidade_saida as cidadeSaida, ");
			hql.append("pais_saida as paisSaida, ");
			hql.append("data_inicio as dataInicio, ");
			hql.append("data_fim as dataFim, ");
			hql.append("valor_pacote as valorPacote, ");
			hql.append("qtd_pct as quantidadePacotes, ");
			hql.append("id_destino as idDestino, ");
			hql.append("id_hotel as idHotel, ");
			hql.append("companhia_id as idCompanhia, ");
			hql.append("id_cliente as idCliente, ");
			hql.append("funcionario_id as idFuncionario ");
			hql.append("FROM pacote ");
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("nomePacote", StringType.INSTANCE);
		    query.addScalar("cidadeSaida", StringType.INSTANCE);
		    query.addScalar("paisSaida", StringType.INSTANCE);
		    query.addScalar("dataInicio", StringType.INSTANCE);
		    query.addScalar("dataFim",StringType.INSTANCE);
		    query.addScalar("valorPacote",FloatType.INSTANCE);
		    query.addScalar("quantidadePacotes",IntegerType.INSTANCE);
		    query.addScalar("idDestino",IntegerType.INSTANCE);
		    query.addScalar("idHotel",IntegerType.INSTANCE);
		    query.addScalar("idCompanhia",IntegerType.INSTANCE);
		    query.addScalar("idCliente",IntegerType.INSTANCE);
		    query.addScalar("idFuncionario",IntegerType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Pacote.class));
			
			
			List<Pacote> obj = query.list();
			
			return obj;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	@SuppressWarnings("unchecked")
	public Pacote findByID(int id) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT pacote_id as id, ");
			hql.append("nome_pacote as nomePacote, ");
			hql.append("cidade_saida as cidadeSaida, ");
			hql.append("pais_saida as paisSaida, ");
			hql.append("data_inicio as dataInicio, ");
			hql.append("data_fim as dataFim, ");
			hql.append("valor_pacote as valorPacote, ");
			hql.append("qtd_pct as quantidadePacotes, ");
			hql.append("id_destino as idDestino, ");
			hql.append("id_hotel as idHotel, ");
			hql.append("companhia_id as idCompanhia, ");
			hql.append("id_cliente as idCliente, ");
			hql.append("funcionario_id as idFuncionario ");
			hql.append("FROM pacote where id="+id);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("nomePacote", StringType.INSTANCE);
		    query.addScalar("cidadeSaida", StringType.INSTANCE);
		    query.addScalar("paisSaida", StringType.INSTANCE);
		    query.addScalar("dataInicio", StringType.INSTANCE);
		    query.addScalar("dataFim",StringType.INSTANCE);
		    query.addScalar("valorPacote",FloatType.INSTANCE);
		    query.addScalar("quantidadePacotes",IntegerType.INSTANCE);
		    query.addScalar("idDestino",IntegerType.INSTANCE);
		    query.addScalar("idHotel",IntegerType.INSTANCE);
		    query.addScalar("idCompanhia",IntegerType.INSTANCE);
		    query.addScalar("idCliente",IntegerType.INSTANCE);
		    query.addScalar("idFuncionario",IntegerType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Pacote.class));
			
			
			List<Pacote> obj = new ArrayList<Pacote>(); 
			obj = query.list();
			Pacote pct = obj.get(0);
			return pct;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public Pacote findByName(String name) {
		try {
			StringBuilder hql = new StringBuilder();
			
			hql.append("SELECT pacote_id as id, ");
			hql.append("nome_pacote as nomePacote, ");
			hql.append("cidade_saida as cidadeSaida, ");
			hql.append("pais_saida as paisSaida, ");
			hql.append("data_inicio as dataInicio, ");
			hql.append("data_fim as dataFim, ");
			hql.append("valor_pacote as valorPacote, ");
			hql.append("qtd_pct as quantidadePacotes, ");
			hql.append("id_destino as idDestino, ");
			hql.append("id_hotel as idHotel, ");
			hql.append("companhia_id as idCompanhia, ");
			hql.append("id_cliente as idCliente, ");
			hql.append("funcionario_id as idFuncionario ");
			hql.append("FROM pacote where nomePacote="+name);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
			
			query.addScalar("id", IntegerType.INSTANCE);
			query.addScalar("nomePacote", StringType.INSTANCE);
		    query.addScalar("cidadeSaida", StringType.INSTANCE);
		    query.addScalar("paisSaida", StringType.INSTANCE);
		    query.addScalar("dataInicio", StringType.INSTANCE);
		    query.addScalar("dataFim",StringType.INSTANCE);
		    query.addScalar("valorPacote",FloatType.INSTANCE);
		    query.addScalar("quantidadePacotes",IntegerType.INSTANCE);
		    query.addScalar("idDestino",IntegerType.INSTANCE);
		    query.addScalar("idHotel",IntegerType.INSTANCE);
		    query.addScalar("idCompanhia",IntegerType.INSTANCE);
		    query.addScalar("idCliente",IntegerType.INSTANCE);
		    query.addScalar("idFuncionario",IntegerType.INSTANCE);
		    
		    query.setResultTransformer(Transformers.aliasToBean(Pacote.class));
			
			
			List<Pacote> obj = new ArrayList<Pacote>(); 
			obj = query.list();
			Pacote pct = obj.get(0);
			return pct;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
			return null;
	}

	public void addPacote(Pacote pacote) {
		// TODO Auto-generated method stub
		
	}

	public void updatePacote(Pacote pacote) {
		// TODO Auto-generated method stub
		
	}

	public void removePacote(Pacote pacote) {
		// TODO Auto-generated method stub
		
	}

}
