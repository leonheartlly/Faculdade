package br.com.unitri.agenciaturismo.locator;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import br.com.unitri.agenciaturismo.service.ClienteService;
import br.com.unitri.agenciaturismo.service.CompanhiaService;
import br.com.unitri.agenciaturismo.service.DestinoService;
import br.com.unitri.agenciaturismo.service.FuncionarioService;
import br.com.unitri.agenciaturismo.service.GaleriaService;
import br.com.unitri.agenciaturismo.service.HotelService;
import br.com.unitri.agenciaturismo.service.PacoteService;
import br.com.unitri.agenciaturismo.service.ReservaService;
import br.com.unitri.agenciaturismo.service.UserRolesService;
import br.com.unitri.agenciaturismo.service.UsersService;


/**
 * Classe responsável por inicializar o Contexto da Aplicação,
 * bem como fornecer acesso aos serviços/beans mapeados no arquivo xml
 *
 */
@Scope("singleton")
@Component
public final class ContextContainer{

	private static ApplicationContext applicationContext;

	public ClienteService getClienteService () throws BeansException {
		return (ClienteService) applicationContext.getBean("clienteService");
	}
	public FuncionarioService getFuncionarioService () throws BeansException {
		return (FuncionarioService) applicationContext.getBean("funcionarioService");
	}
	public CompanhiaService getCompanhiaService () throws BeansException {
		return (CompanhiaService) applicationContext.getBean("companhiaService");
	}
//	public GaleriaService getGaleriaService () throws BeansException {
//		return (GaleriaService) applicationContext.getBean("galeriaService");
//	}
	public HotelService getHotelService () throws BeansException {
		return (HotelService) applicationContext.getBean("hotelService");
	}
	public PacoteService getPacoteService () throws BeansException {
		return (PacoteService) applicationContext.getBean("pacoteService");
	}
	public ReservaService getReservaService () throws BeansException {
		return (ReservaService) applicationContext.getBean("reservaService");
	}
	public UsersService getUsersService () throws BeansException {
		return (UsersService) applicationContext.getBean("usersService");
	}
	public DestinoService getDestinoService() throws BeansException{
		return (DestinoService) applicationContext.getBean("destinoService");
	}
	public UserRolesService getUserRolesService() throws BeansException{
		return (UserRolesService) applicationContext.getBean("userRolesService");
	}
	
	public static synchronized ContextContainer getInstance() {
		
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		
		return instance;
	}

	private static ContextContainer instance = new ContextContainer();

	private ContextContainer() {
	}
}
