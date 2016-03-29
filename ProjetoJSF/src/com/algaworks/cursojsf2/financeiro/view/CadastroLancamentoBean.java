package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;

import build.classes.com.algaworks.cursojsf2.financeiro.utils.FacesUtil;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.HibernateUtil;

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
	
	/**
	 * Chamado primeiro sempre que for instanciado.
	 */
	@PostConstruct //Usado para chamar primeiro sempre.
	@SuppressWarnings("unchecked")
	public void init(){
		
		//Usado apenas para mock
//		GestaoPessoas gestaoPessoas = new GestaoPessoas();
//		this.pessoas = gestaoPessoas.listarTodas();
		
		Session session = (Session)FacesUtil.getRequestAttribute("session");//session setado em hibernatesessionfilter
		
		this.pessoas = session.createCriteria(Pessoa.class)
				.addOrder(Order.asc("nome"))//ordena por nome
				.list();
	}
	
	/**
	 * Cadastra um novo produto.(imprime na tela)
	 */
	public void cadastrar() {

		Session session = (Session)FacesUtil.getRequestAttribute("session");
		session.merge(this.lancamento);//insere dados no bd, se ja existir atualiza, se nao insere
		
//		Session session = HibernateUtil.getSession();
//		Transaction trans = session.beginTransaction();//inicia transacao com o bd
		
//		trans.commit();
//		session.close();
		//Novo lançamento instanciado para limpar a tela
		this.lancamento = new Lancamento();
		
		String msg = "Cadastro efetuado com sucesso!";
		//Adiciona uma mensagem de resposta à fila.
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
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