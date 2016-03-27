package com.algaworks.cursojsf2.financeiro.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;

@FacesConverter(forClass = Pessoa.class) //registra o conversor (forClass = Pessoa.class) = seta automaticamente o uso deste conversor para esta classe.
public class PessoaConverter implements Converter{

	/**
	 * Conversor de entrada.view/controller
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String value) {
		Pessoa pessoa = null;
		
		if(value != null){
			GestaoPessoas gestaoPessoas = new GestaoPessoas();
			pessoa = gestaoPessoas.buscarPorCodigo(new Integer(value));
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
