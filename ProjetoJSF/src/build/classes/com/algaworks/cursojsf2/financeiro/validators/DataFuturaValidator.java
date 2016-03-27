package build.classes.com.algaworks.cursojsf2.financeiro.validators;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.DataFutura") //valida o validador
public class DataFuturaValidator implements Validator{

	/**
	 * Validador de data.
	 * Efetua validação da data nao permitindo valor posterior a data atual.
	 */
	@Override
	public void validate(FacesContext context, UIComponent ui, Object value) 
			throws ValidatorException {

		Date data = (Date)value;
		
		if(data != null && data.after(new Date())){//verifica se a data nao é posterior a hoje
			Object label = MessageFactory.getLabel(context, ui);
			String msg = label + " Não é permitido datas futuras."; 
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					msg, msg);
			throw new ValidatorException(message);
		}
	}

}
