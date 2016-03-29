package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;

import build.classes.com.algaworks.cursojsf2.financeiro.utils.FacesUtil;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	@PostConstruct
	@SuppressWarnings("unchecked")
	public void inicializar() {
//		Session session = HibernateUtil.getSession();
		Session session = (Session)FacesUtil.getRequestAttribute("session");
		
		lancamentos = session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
		
//		session.close();
	}

	public void excluir(){
		if(lancamentoSelecionado.isPago()){
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lancamentos pagos não podem ser excluidos!.");
		}else{
			Session session = (Session)FacesUtil.getRequestAttribute("session");			
//			Transaction trans = session.beginTransaction();
			
			session.delete(lancamentoSelecionado);
			
//			trans.commit();
//			session.close();
			
			this.inicializar();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lancamento excluido com sucesso!.");
		}
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
	
	
}