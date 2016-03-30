package com.algaworks.cursojsf2.financeiro.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.IPessoas;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.FacesUtil;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.HibernateUtil;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.Repositorios;

@FacesConverter(forClass = Pessoa.class) //registra o conversor (forClass = Pessoa.class) = seta automaticamente o uso deste conversor para esta classe.
public class PessoaConverter implements Converter{

	private Repositorios repositorios = new Repositorios();
	
	/**
	 * Conversor de entrada.view/controller
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String value) {
		Pessoa pessoa = null;
		
		if(value != null){
			IPessoas pessoas = this.repositorios.getPessoas();
			
			pessoa = pessoas.consultarPorID(new Integer(value));
			
//			GestaoPessoas gestaoPessoas = new GestaoPessoas();
//			pessoa = gestaoPessoas.buscarPorCodigo(new Integer(value));
			
		}
		return pessoa;
	}

	/**
	 * Conversor de saida. controller/view
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object value) {
		if(value != null){
		return ((Pessoa)value).getCodigo().toString();
		}
		return null;
	}

}
