package build.classes.com.algaworks.cursojsf2.financeiro.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.RequerimentoCondicional")
public class RequerimentoCondicionalValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException {
		
		Boolean checado = (Boolean)component.getAttributes().get("checado");
				
		if(checado != null && checado && value == null){
			Object label = MessageFactory.getLabel(context, component);
			
			
			
			String msg = "Preencha o campo " + label+".";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					msg, msg);
			throw new ValidatorException(message);
		}
	}

}
