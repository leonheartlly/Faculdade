using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;

namespace Utils.Geral.Genetic.Scaling
{
    public class FuncoesEscala
    {
        /// <summary>
        /// Mantém 
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="populacao"></param>
        /// <returns></returns>
        public static PopulacaoAvaliada<T> SemEscala<T>(PopulacaoAvaliada<T> populacao) where T : Individuo
        {
            return populacao;
        }

        /// <summary>
        /// Refaz a escala dos indivíduos de modo que cada um receba a pontuação de acordo com sua ordem.
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="populacao"></param>
        /// <returns></returns>
        public static PopulacaoAvaliada<T> Ranking<T>(PopulacaoAvaliada<T> populacao) where T : Individuo
        {            
            PopulacaoAvaliada<T> scaled = new PopulacaoAvaliada<T>();
        
            uint i = 1;
            foreach (Avaliado<T> avaliado in populacao)        
                scaled.Adicionar(avaliado, i++);

            return scaled;                       
        }
    }
}
