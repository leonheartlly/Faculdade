package build.classes.com.algaworks.cursojsf2.financeiro.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {


	public static void adicionarMensagem(Severity tipo, String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo,
				mensagem, mensagem));
	}
	
	public static void adicionarMensagem(Severity tipo, String sumario, String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo,
				sumario, mensagem));
	}
	
	public static Object getRequestAttribute(String name){
		//para obter a sessão atual
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(name);
	}
}
