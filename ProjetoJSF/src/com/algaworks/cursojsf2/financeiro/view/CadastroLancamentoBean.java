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

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;

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
	public void init(){
		
		GestaoPessoas gestaoPessoas = new GestaoPessoas();
		this.pessoas = gestaoPessoas.listarTodas();
	}
	
	/**
	 * Cadastra um novo produto.(imprime na tela)
	 */
	public void cadastrar() {
		System.out.println("Tipo: " + this.lancamento.getTipo());
		System.out.println("Pessoa: " + this.lancamento.getPessoa().getNome());
		System.out.println("Descrição: " + this.lancamento.getDescricao());
		System.out.println("Valor: " + this.lancamento.getValor());
		System.out.println("Data vencimento: " + this.lancamento.getDataVencimento());
		System.out.println("Conta paga: " + this.lancamento.isPago());
		System.out.println("Data pagamento: " + this.lancamento.getDataPagamento());

		//Novo lançamento instanciado para limpar a tela
		this.lancamento = new Lancamento();
		
		//TODO cadastrar BD.
		
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