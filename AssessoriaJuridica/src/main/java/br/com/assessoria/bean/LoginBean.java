package br.com.assessoria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {

	public String logar(){
		return "index.xhtml";
	}
}
