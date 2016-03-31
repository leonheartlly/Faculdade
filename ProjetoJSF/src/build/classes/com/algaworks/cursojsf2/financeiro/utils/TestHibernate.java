package build.classes.com.algaworks.cursojsf2.financeiro.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public class TestHibernate {

	//@SuppressWarnings("unchecked")
	/*public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		//busca do banco a lista de todas as pessoas
		List<Pessoa> pessoas = new ArrayList<Pessoa>(); 
		pessoas = session.createCriteria(Pessoa.class)
				.add(Restrictions.gt("codigo", 3))//cria restrição, neste caso, greater than 3 em codigo //sem esta lista tudo
				.list();
		
		for(Pessoa pessoa : pessoas){
			System.out.println("Id: "+pessoa.getCodigo()+"\n Nome: "+ pessoa.getNome());
		}
		
		session.close();
	}*/
}
