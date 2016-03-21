using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;

namespace Utils.Geral.Genetic.Selection
{
    /// <summary>
    /// Seleciona um grupo de individuos com base em algum critério.
    /// </summary>
    /// <typeparam name="T">O tipo do indivíduo</typeparam>
    /// <param name="populacao">A população de onde os indivíduos sairão</param>
    /// <param name="quantidade">Número de indivíduos a serem selecionados.</param>
    /// <returns>Os indivíduos selecionados</returns>
    public delegate PopulacaoAvaliada<T> FuncaoSelecao<T>(PopulacaoAvaliada<T> populacao, int quantidade) where T : Individuo;
}
