package build.classes.com.algaworks.cursojsf2.financeiro.repository;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;

public interface ILancamentos {

	public List<Lancamento> constultarLancamentos();
	
	public Lancamento constultarPorID(Integer codigo);
	
	public Lancamento salvarLancamento(Lancamento lancamento);
	
	public void deletaLancamento(Lancamento lancamento);
	
	public Lancamento comDadosIguais(Lancamento lancamento);
}
