using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;

namespace Utils.Geral.Genetic.Scaling
{
    /// <summary>
    /// O objetivo de uma função de escala é reorganizar o escore dos indivíduos com base em algum critério. 
    /// Ao final do processo, a população ainda deve estar ordenada.
    /// </summary>
    /// <typeparam name="T">Tipo do indivíduo</typeparam>
    /// <param name="populacao">População antes da escala</param>
    /// <returns>A população com o escore após a escala.</returns>
    public delegate PopulacaoAvaliada<T> FuncaoEscala<T>(PopulacaoAvaliada<T> populacao) where T : Individuo;
}
