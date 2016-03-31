package br.com.unitri.agenciaturismo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ManagedBean(name="TesteBean")
@SessionScoped
@Component
@Scope("session")
public class TesteBean {

//	private List<Cliente> list;
//	private Cliente pessoa;
//	
//	@PostConstruct
//	public void init(){
//		listAll();
//	}
//	@PreDestroy
//	public void destroy(){
//		
//	}
//	
//	public void listAll(){
//		list = ContextContainer.getInstance().getClienteService().listAll();
//	}
//	
//	public void deletar(){
//		ContextContainer.getInstance().getClienteService().removePessoa(pessoa);
//
//	}
}
