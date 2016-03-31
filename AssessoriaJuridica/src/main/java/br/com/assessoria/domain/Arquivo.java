package br.com.assessoria.domain;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;

public class Arquivo {
	
	public void processarArquivo(FileUploadEvent event){
		
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(event.getFile().getInputstream());
			
	        BufferedReader in = new BufferedReader(isr);  
	        
	        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); // Context  
	        HttpSession session = (HttpSession) context.getSession(false);
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	        
	        //Coordenadas
	        double[]coordinatesUTM = new double[2];
	        
	        outStream.write("COD;X;Y".getBytes());
	        
	        //CabeÃ§alho
	        String line = in.readLine();                
	        while((line = in.readLine()) != null){ 
	           System.out.println(line);
	           String result [] = line.split(";");
	           String a = result[0];
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "reste!",""));
	}

}
