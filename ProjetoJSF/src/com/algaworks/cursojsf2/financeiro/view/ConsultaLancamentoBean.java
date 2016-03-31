package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.service.RegraNegocioException;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.ILancamentos;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.FacesUtil;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.Repositorios;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	private Repositorios repositorios = new Repositorios();
	
	@PostConstruct
	public void inicializar() {
		ILancamentos lancamentos = this.repositorios.getLancamentos();

		this.lancamentos = lancamentos.constultarLancamentos();
	}

	public void excluir(){
		
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.excluir(lancamentoSelecionado);
			
			this.inicializar();//para limpar recarregando 
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lancamento excluido com sucesso!.");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lancamentos pagos não podem ser excluidos!." + e.getMessage());
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