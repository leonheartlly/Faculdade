package br.com.assessoria.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import br.com.assessoria.domain.Email;

@ManagedBean
@SessionScoped
public class EnviarEmailBean {
	private Email email = new Email();
	
	public void enviaEmailComAnexo() throws EmailException{
		
			try {
		//			// cria o anexo 1.
		//			EmailAttachment anexo1 = new EmailAttachment();
		//			anexo1.setPath("/home/elton/Script-teste-ConverterData.sh"); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)
		//			anexo1.setDisposition(EmailAttachment.ATTACHMENT);
		//			anexo1.setDescription("Exemplo de arquivo anexo");
		//			anexo1.setName("Script-teste-ConverterData.sh");		
		//			
		//			// cria o anexo 2.
		//			EmailAttachment anexo2 = new EmailAttachment();
		//			anexo2.setPath("/home/elton/discovery.inventory.sql"); //caminho do arquivo (RAIZ_PROJETO/teste/teste2.jsp)
		//			anexo2.setDisposition(EmailAttachment.ATTACHMENT);
		//			anexo2.setDescription("Exemplo de arquivo anexo");
		//			anexo2.setName("discovery.inventory.sql");		
		//			
					// configura o email
					MultiPartEmail multiPartEmail = new MultiPartEmail();
					multiPartEmail.setHostName(email.getServidorEmail()); // o servidor SMTP para envio do e-mail
					multiPartEmail.addTo(email.getDestinatario(), email.getNomeCliente()); //destinatário
					multiPartEmail.setFrom(email.getRemetente(), email.getNomeEmail()); // remetente
					multiPartEmail.setSubject(email.getAssunto()); // assunto do e-mail
					multiPartEmail.setMsg(email.getTexto()); //conteudo do e-mail
					multiPartEmail.setAuthentication(email.getRemetente(), email.getSenha());
					multiPartEmail.setSmtpPort(email.getPortaServidorEmail());
					multiPartEmail.setSSL(true);
					multiPartEmail.setTLS(true);
					
		//			// adiciona arquivo(s) anexo(s)
		//			multiPartEmail.attach(anexo1);
		//			multiPartEmail.attach(anexo2);
					
					// envia o email
					multiPartEmail.send();
					email = new Email();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Email enviado com sucesso!",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao enviar email!",""));
			}
	}

	
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}	
}
