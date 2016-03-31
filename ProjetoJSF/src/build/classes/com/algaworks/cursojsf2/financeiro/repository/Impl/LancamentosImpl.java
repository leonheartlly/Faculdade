package build.classes.com.algaworks.cursojsf2.financeiro.repository.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.ILancamentos;

public class LancamentosImpl implements ILancamentos{

	private Session session;
	
	public LancamentosImpl(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> constultarLancamentos() {
		return this.session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
	}

	@Override
	public Lancamento constultarPorID(Integer codigo) {
		return (Lancamento)this.session.get(Lancamento.class, codigo);
	}

	@Override
	public Lancamento salvarLancamento(Lancamento lancamento) {
		return (Lancamento)this.session.merge(lancamento);
	}

	@Override
	public void deletaLancamento(Lancamento lancamento) {
		this.session.delete(lancamento);
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		
		return (Lancamento)this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", lancamento.getTipo()))
				.add(Restrictions.eq("pessoa", lancamento.getPessoa()))
				.add(Restrictions.ilike("descricao", lancamento.getDescricao()))
				.add(Restrictions.eq("valor", lancamento.getValor()))
				.add(Restrictions.eq("dataVencimento", lancamento.getDataVencimento()))
				.uniqueResult();
	}

}
