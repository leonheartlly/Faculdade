package com.algaworks.cursojsf2.financeiro.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;

import build.classes.com.algaworks.cursojsf2.financeiro.repository.ILancamentos;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.FacesUtil;
import build.classes.com.algaworks.cursojsf2.financeiro.utils.Repositorios;

@FacesConverter(forClass=Lancamento.class)
public class LancamentoConverter implements Converter{

	private Repositorios repositorios = new Repositorios(); 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Lancamento retorno = null;
		
		ILancamentos lancamentos = this.repositorios.getLancamentos();
		
		if(value != null && !value.equals("")){
			retorno = lancamentos.constultarPorID(new Integer(value));
			
			
			if(retorno == null){
				String descErr = "Lancamento não existe!.";
				
				FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, descErr);
				
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Integer codigo = ((Lancamento)value).getCodigo();
			return codigo == null ? "":codigo.toString();
		}
		return null;
	}

}
