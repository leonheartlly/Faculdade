package br.com.unitri.maquinario;

import java.util.Hashtable;

public class Estado
{
	/* This hashtable stores an entry for each character in the machine's
	 * alphabet, and the state the machine should move to after receiving that
	 * character as input while in this state.
	 */
	private Hashtable<Character, Estado> tabela;
	/* Um identificador para o estado */
	private String nome;
	
	public Estado(String nome)
	{
		this.nome = nome;
		tabela = new Hashtable<Character, Estado>();
	}
	
	/* Returns what state to move to with a given input. Looks up the input
	 * character in this state's hashtable and returns the corresponding state.
	 */
	public Estado proximoEstado(Character entrada)
	{
		return tabela.get(entrada);
	}
	
	/* Add uma transicao à hashtable */
	public void addTransicao(Character entrada, Estado proximo)
	{
		tabela.put(entrada, proximo);
	}
	
	/* Remove uma transicao da hashtable. */
	public void removeTransicao(Character entrada)
	{
		tabela.remove(entrada);
	}
	
	/* Retorna true se o estado é igual a este. A unica propriedade
	 * comparada é o nome.
	 */
	@Override
	public boolean equals(Object s)
	{
		if (this == s) return true;
		if (!(s instanceof Estado)) return false;
		
		Estado state = (Estado) s;
		return nome.equals(state.getNome());
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String toString()
	{
		return nome;
	}
}
