package build.classes.com.algaworks.cursojsf2.financeiro.repository.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.IPessoas;

public class PessoasImpl implements IPessoas{

	private Session session;
	
	public PessoasImpl(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> consultarTodas() {
		return this.session.createCriteria(Pessoa.class)
				.addOrder(Order.asc("nome"))
				.list();
	}

	@Override
	public Pessoa consultarPorID(Integer codigo) {
		return (Pessoa) this.session.get(Pessoa.class, codigo);
	}

	
}
