package br.com.unitri.maquinario;


import java.util.Vector;


public class Minimizador
{
	
	public static Maquina minimiza(Maquina maquina)
	{
		Vector<EstadoPar> pares = new Vector<EstadoPar>();
		
		/* Constroi uma lista de todos os pares (p,q) p e q sao elementos de
		 * Q.
		 */
		for (Estado p : maquina.getQ())
		{
			for (Estado q : maquina.getQ())
			{
				EstadoPar par = new EstadoPar(p, q);
				
				if (!pares.contains(par))
				{
					pares.add(par);

					if (maquina.getF().contains(p) && maquina.getF().contains(q) ||
							!maquina.getF().contains(p) && !maquina.getF().contains(q))
						par.naoDistinquivel = true;
				}
			}
		}
		
		
		boolean alterado = true;
		while (alterado)
		{	
			alterado = false;
			
			for (EstadoPar par : pares)
			{	
				if (par.naoDistinquivel)
				{
					for (char a : maquina.getAlfabeto())
					{
						EstadoPar proximoPar = new EstadoPar(par.p.proximoEstado(a), 
								par.q.proximoEstado(a));

						// Converte este EstadoPar para seu equivalente na lista
						proximoPar = pares.get(pares.indexOf(proximoPar));

						if (!proximoPar.naoDistinquivel)
						{
							par.naoDistinquivel = false;
							alterado = true;
						}
					}
				}
			}
		}
		
		/* printa a tabela de compatibilidade */
		System.out.println("Tabela de Compatibilidade:");
		for (EstadoPar par : pares)
		{
			if (!par.p.equals(par.q))
				System.out.println(par);
		}
		
		/* merge estados. */
		for (EstadoPar par : pares)
		{
			if (par.naoDistinquivel && !par.p.equals(par.q))
			{
				for (Estado estado : maquina.getQ())
				{
					// Muda transicoes de p para q 
					for (char a : maquina.getAlfabeto())
					{
						if (estado.proximoEstado(a).equals(par.p))
						{
							estado.removeTransicao(a);
							estado.addTransicao(a, par.q);
						}
					}
				}
				
				maquina.getQ().remove(par.p);
			}
		}
		
		return maquina;
	}
}
