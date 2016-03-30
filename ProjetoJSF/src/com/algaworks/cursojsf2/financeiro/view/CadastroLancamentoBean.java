package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.service.RegraNegocioException;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.IPessoas;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.FacesUtil;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	/**
	 * Variável de instância de Lançamento.
	 */
	private Lancamento lancamento = new Lancamento();

	/**
	 * Variável de instância de Pessoa
	 */
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	private Repositorios repositorios = new Repositorios();
	
	/**
	 * Chamado primeiro sempre que for instanciado.
	 */
	@PostConstruct //Usado para chamar primeiro sempre.
	public void init(){
		
		IPessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.consultarTodas();
	}
	
	/**
	 * Cadastra um novo produto.(imprime na tela)
	 */
	public void cadastrar() {

		
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.salvar(this.lancamento);
			
			//Novo lançamento instanciado para limpar a tela
			this.lancamento = new Lancamento();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro Efetuado com sucesso!.");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar lancamento.");
		}
	}

	/**
	 * Escuta o checkbox ao modificar.
	 * Através do imediate adianta alguns passos para o valor de lancamento.pago para efetuar validações posteriores.
	 * @param event
	 */
	public void lancamentoPagoModificado(ValueChangeEvent event){
		this.lancamento.setPago((Boolean)event.getNewValue());
		lancamento.setDataPagamento(null);
		//força a ir para a ultima fase pulando todas as validações
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	/**
	 * Retorna os enumeradores.	
	 * @return
	 */
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	/**
	 * Obtém Lançamento.
	 * @return lancamento
	 */
	public Lancamento getLancamento() {
		return lancamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	
}