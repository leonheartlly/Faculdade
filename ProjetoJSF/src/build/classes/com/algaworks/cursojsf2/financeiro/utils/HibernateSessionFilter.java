package build.classes.com.algaworks.cursojsf2.financeiro.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames={"Faces Servlet"}) //intercepta o faces servlet
public class HibernateSessionFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Session session = HibernateUtil.getSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			request.setAttribute("session", session);//abre a transacao
			
			chain.doFilter(request, response);//obrigatório, permite continuar a execução com a transacao aberta
			
			trans.commit();
		}catch(Exception e){
			if(trans != null){
				trans.rollback();
			}
		}finally{
			session.close();
		}
	}

	@Override	
	public void init(FilterConfig config) throws ServletException {
		
	}
	
	
	@Override
	public void destroy() {
		
	}

}
