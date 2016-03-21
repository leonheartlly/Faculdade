using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;

namespace Utils.Geral.Genetic.Scaling
{
    /// <summary>
    /// "Escala todas as fitness da população com base no desvio padrão do grupo inteiro,
    /// o que significa que existe mais pontuação quando o grupo é mais heterogênero (ou seja,
    /// no início da simulação) e tem menos efeito na convergência a medida que o grupo fica
    /// mais homogêneo." (Brian Schwab)
    /// 
    /// O valor de fitness escalado (F') é calculado na forma F' = (F^ - c * sigma), onde
    /// F é o valor da pontuação, F^ é a média, sigma é o desvio padrão da população e c
    /// é um multiplicador aceitável, geralmente entre 1 e 3. 
    /// </summary>
    /// <typeparam name="T">Tipo do indivíduo</typeparam>
    public class CorteDesvioPadrao<T> where T  : Individuo 
    {
        private double c;

        /// <summary>
        /// Cria uma nova classe de escala por corte no desvio padrão.
        /// </summary>
        /// <param name="c"></param>
        public CorteDesvioPadrao(double c)
        {
            this.c = c;
        }

        public PopulacaoAvaliada<T> Escala(PopulacaoAvaliada<T> populacao) {        
            //Calculo do desvio padrão (Sigma)
            double soma = 0;
            double media = populacao.Media;
            foreach (Avaliado<T> avaliado in populacao) {
                double dif = avaliado.Pontuacao - media;
                soma += dif * dif;
            }
            double sigma = Math.Sqrt(soma / populacao.Count);

            //Finalmente, calcula a pontuação
            PopulacaoAvaliada<T> populacaoEscala = new PopulacaoAvaliada<T>();
            foreach (Avaliado<T> avaliado in populacao) {
                double fitness = avaliado.Pontuacao - (media - c * sigma);
                populacaoEscala.Adicionar(avaliado, fitness < 0 ?  0 : (uint)fitness);
            }

            populacaoEscala.Sort();
            return populacaoEscala;
        }
    }

}
