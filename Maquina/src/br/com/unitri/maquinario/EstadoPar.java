package br.com.unitri.maquinario;

public class EstadoPar
{
	public Estado p, q;
	public boolean naoDistinquivel;
	
	public EstadoPar(Estado p, Estado q)
	{
		this.p = p;
		this.q = q;
		
		naoDistinquivel = false;
	}
	
	/* Retorna true se ambos os estados aqui também estiverem em sp. */
	@Override
	public boolean equals(Object ep)
	{
		if (this == ep) return true;
		if (!(ep instanceof EstadoPar)) return false;
		
		EstadoPar statePair = (EstadoPar) ep;
		return (this.p.equals(statePair.p) && this.q.equals(statePair.q)) || 
				(this.p.equals(statePair.q) && this.q.equals(statePair.p));
	}
	
	@Override
	public String toString()
	{
		return p + ", " + q + ": " + (naoDistinquivel ? "Incompativel" : "Compativel");
	}
}
