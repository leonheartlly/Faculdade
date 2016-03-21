package br.com.AutoOMU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class ExecPerl {
	LogsOMU log = LogsOMU.getInstance();
	Process process;
	public void perl() throws IOException, InterruptedException{
		
		String [] cmd = new String[]{"perl","C:\\Users\\Lucas\\Desktop\\perls.pl","C:\\Users\\Lucas\\Desktop\\lucas.txt"};
		process = Runtime.getRuntime().exec(cmd);
			
		 BufferedReader stdInput = new BufferedReader(new 
	             InputStreamReader(process.getInputStream()));

	        BufferedReader stdError = new BufferedReader(new 
	             InputStreamReader(process.getErrorStream()));
	        
	        	

	        // ler a saida do comando
	        String s = null;
	        while ((s = stdInput.readLine()) != null) {
	        	System.out.println(s);
	        	
	        }
	        log.log(Level.INFO, "Script perl executado com sucesso!");
	        // Leitura de qualquer erro ao executar o comando
	        while ((s = stdError.readLine()) != null) {
	    	    log.log(Level.SEVERE, "ERRO GRAVE! NÃO FOI POSSÍVEL EXECUTAR O SCRIPT PERL "+s);	        
	            
	        }

	}

}
