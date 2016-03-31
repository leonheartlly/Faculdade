package build.classes.com.algaworks.cursojsf2.financeiro.utils;

import java.io.Serializable;

import org.hibernate.Session;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.Impl.LancamentosImpl;
import build.classes.com.algaworks.cursojsf2.financeiro.repository.Impl.PessoasImpl;

public class Repositorios implements Serializable{

	/**
	 * Obtem sessao para pessoas
	 * @return
	 */
	public PessoasImpl getPessoas(){
		return new PessoasImpl(this.getSession());
	}
	
	public LancamentosImpl getLancamentos(){
		return new LancamentosImpl(this.getSession());
	}
	
	private Session getSession(){
		return (Session)FacesUtil.getRequestAttribute("session");
	}
}
