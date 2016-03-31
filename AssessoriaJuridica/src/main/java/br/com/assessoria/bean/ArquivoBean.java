package br.com.assessoria.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import br.com.assessoria.domain.Arquivo;



@ManagedBean
@SessionScoped
public class ArquivoBean {
	private Arquivo arquivo;

    public void handleFileUpload(FileUploadEvent event) {
    	arquivo = new Arquivo();
    	arquivo.processarArquivo(event);
       
    	String name = event.getFile().getFileName();
        Long size = event.getFile().getSize();
        String type = event.getFile().getContentType();
         
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload com sucesso!",""));
    }

}