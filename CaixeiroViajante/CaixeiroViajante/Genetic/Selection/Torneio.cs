using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;
using Utils.Geral.Genetic;

namespace CaixeiroViajante.Genetic.Selection
{
    /// <summary>
    /// Seleciona um grupo de indivíduos. Aquele com maior genoma, vence o torneio.
    /// </summary>
    public class Torneio<T> where T : Individuo
    {
        private int quant;
        public Torneio(int quant)
        {
            this.quant = quant;
        }

        public PopulacaoAvaliada<T> Selecionar(PopulacaoAvaliada<T> populacao, int quantidade)
        {
            populacao.Sort();
            Random random = new Random();
            PopulacaoAvaliada<T> selecionados = new PopulacaoAvaliada<T>();

            int count = 0;
            while (count < quantidade)
            {
                Avaliado<T> maior = populacao[random.Next(populacao.Count)];
                for (int i = 0; i < quant - 1; i++)
                {
                    Avaliado<T> tmp = populacao[random.Next(populacao.Count)];
                    if (tmp.Pontuacao > maior.Pontuacao)
                        maior = tmp;
                }
                selecionados.Adicionar(maior);
            }

            return selecionados;
        }
    }

}
