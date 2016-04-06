package br.com.unitri.maquinario;

import java.util.Vector;

public class Maquina
{
	// Marcadores para começo e termino de estados
	public static final String INDICADOR_INICIAL = "->";
	public static final String INDICADOR_FINAL = "*";
	
	
	private Vector<Estado> Q, F;
	// Alfabeto
	private Vector<Character> alfabeto;
	// Estado inicial
	private Estado inicial;
	
	// Estado atual da maquina
	private Estado atual;
	
	public Maquina(Vector<Estado> Q, Vector<Character> alfabeto, Estado inicial,
			Vector<Estado> F)
	{
		this.Q = Q;
		this.alfabeto = alfabeto;
		this.inicial = inicial;
		this.F = F;
		
		atual = inicial;
	}
	
	/* Executa a maquina com a palavra dada. Retorna true se a palavra é na
	 * linguagem aceita pela maquina, false caso nao seja.
	 */
	public boolean palavraNaLinguagem(String entrada)
	{
		boolean palavraNaLinguagem = false;
		
		try
		{
			for (Character ch : entrada.toCharArray())
			{
				proximoEstado(ch);
			}
			
			if (F.contains(atual))
				palavraNaLinguagem = true;
		}
		catch (Exception ex)
		{
			System.err.println("Entrada Invalida.");
		}
		
		return palavraNaLinguagem;
	}
	
	/* Move ao proximo estado. 
	 */
	public void proximoEstado(Character entrada) throws Exception
	{
		if (alfabeto.contains(entrada))
			atual = atual.proximoEstado(entrada);
		else
			throw new Exception("Elemento não está no alfabeto.");
	}

	public Vector<Estado> getQ()
	{
		return Q;
	}

	public void setQ(Vector<Estado> Q)
	{
		this.Q = Q;
	}

	public Vector<Character> getAlfabeto()
	{
		return alfabeto;
	}

	public void setAlfabeto(Vector<Character> alfabeto)
	{
		this.alfabeto = alfabeto;
	}

	public Estado getInicial()
	{
		return inicial;
	}

	public void setInicial(Estado inicial)
	{
		this.inicial = inicial;
	}

	public Vector<Estado> getF()
	{
		return F;
	}

	public void setF(Vector<Estado> F)
	{
		this.F = F;
	}

	public Estado getEstadoAtual()
	{
		return atual;
	}

	public void setEstadoAtual(Estado atual)
	{
		this.atual = atual;
	}
	
	public String toString()
	{
		String stringRep = INDICADOR_INICIAL + ' ' + inicial + '\n';
		
		for (Estado q : Q)
		{
			for (char ch : alfabeto)
			{
				stringRep += q.toString() + ' ' + ch + ' ' + q.proximoEstado(ch) + '\n';
			}
		}
		
		for (Estado f : F)
		{
			stringRep += INDICADOR_FINAL + ' ' + f + '\n';
		}
		
		return stringRep;
	}
}
