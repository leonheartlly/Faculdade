package build.classes.com.algaworks.cursojsf2.financeiro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static{
		try{
			Configuration configuration = new Configuration();
			configuration.configure().buildSessionFactory();//efetua leitura do arquivo xml
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();//passa as configurações do xml pra um construtor de service registry
			
			//busca uma fabrica de sessão e atribui sessionFactory
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * Abre a conexão com o banco de dados e retorna a sessão.
	 * @return
	 */
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
