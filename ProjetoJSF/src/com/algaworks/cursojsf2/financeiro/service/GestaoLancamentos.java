package com.algaworks.cursojsf2.financeiro.service;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.ILancamentos;

public class GestaoLancamentos {

	private ILancamentos lancamentos;
	
	public GestaoLancamentos(ILancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException{
		
		if(lancamento.isPago()){
			throw new RegraNegocioException("Lancamento Pago não pode ser excluido!");
		}
		this.lancamentos.deletaLancamento(lancamento);
		
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException{
		
		if(lancamentoESemelhante(lancamento)){
			throw new RegraNegocioException("Já existe lançamento semelhante!.");
		}
		this.lancamentos.salvarLancamento(lancamento);
	}
	
	public boolean lancamentoESemelhante(Lancamento lancamento){
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
		
	}
}
