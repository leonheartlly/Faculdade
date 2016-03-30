package build.classes.com.algaworks.cursojsf2.financeiro.repository;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public interface IPessoas {

	public List<Pessoa> consultarTodas();
	
	public Pessoa consultarPorID(Integer codigo);
}
