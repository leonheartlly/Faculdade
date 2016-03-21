using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;

namespace Utils.Geral.Genetic.Selection
{
    /// <summary>
    /// Seleciona indivíduos com base no algorítmo de seleção assintótica, proposto por 
    /// Mendonca, V., Pozzer C.T. e Raiitz, P.
    /// 
    /// Neste algorítmo, a seleção é controlada por um expoente, normalmente é um valor entre 0 e 2. 
    /// Se esse expoente for menor que 1, objetos de menor escore são priorizados;
    /// Se o expoente for maior do que 1, objetos de maior escore são priorizados;
    /// Se o expoente for igual a 1, o comportamento da função é totalmente aleatório.
    /// </summary>
    public class SelecaoAssintotica<T> where T : Individuo
    {
	    private double expoente;

	    public SelecaoAssintotica(double exponente) {
		    this.expoente = exponente;
	    }
	    
	    public PopulacaoAvaliada<T> Selecionar(PopulacaoAvaliada<T> populacao, int quantidade) {
		    populacao.Sort();
		    Random random = new Random();
		    PopulacaoAvaliada<T> selecionados = new PopulacaoAvaliada<T>();

		    for (int i = 0; i < quantidade; i++) {
			    // Generate a number from 0 to size()-1
			    int indice = (int) (populacao.Count * Math.Pow(random.NextDouble(), expoente));
			    selecionados.Adicionar(populacao[indice]);
		    }
		    return selecionados;
	    }
    }
}
