using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;
using CaixeiroViajante.Genetic.Selection;

namespace Utils.Geral.Genetic.Selection
{
    public class FuncoesSelecao
    {
        private delegate IList<ulong> SortearSomas<T>(int quantidade, PopulacaoAvaliada<T> populacao) where T : Individuo;

        /// <summary>
        /// Representa o processo de seleção assintótica com expoente 1.1 (padrão).
        /// </summary>
        /// <typeparam name="T">Tipo do indivíduo.</typeparam>
        /// <param name="populacao">População</param>
        /// <param name="quantidade">Quantidade a ser selecionado</param>
        /// <returns>Os indivíduos selecionados</returns>
        /// <seealso cref="SelecaoAssintotica"/>
        public static PopulacaoAvaliada<T> Assintotica<T>(PopulacaoAvaliada<T> populacao, int quantidade) 
            where T : Individuo
        {
            return new SelecaoAssintotica<T>(1.1).Selecionar(populacao, quantidade);
        }

        /// <summary>
        /// Imagine uma roda da sorte, onde cada faixa é tão larga quanto o escore do indivíduo.
        /// Cada vez, você gira a roda, o que significa que indivíduos de melhor escore terão mais
        /// chances de serem selecionados. Esse algoritmo simula essa roda.
        /// </summary>
        /// <typeparam name="T">Tipo do indivíduo.</typeparam>
        /// <param name="populacao">População</param>
        /// <param name="quantidade">Quantidade a ser selecionado</param>
        /// <returns></returns>
        public static PopulacaoAvaliada<T> RoletaDaSorte<T>(PopulacaoAvaliada<T> populacao, int quantidade) 
            where T : Individuo
        {
            return SelecaoPorRoda<T>(SorteioRodaSorte, populacao, quantidade);
        }

        /// <summary>
        /// Divide o universo numa roda, onde cada pedaço é proporcional ao escore do indivíduo.
        /// Então, ao invés de gerar a roda aleatoriamente, simplesmente a inclina em alguns graus,
        /// e pega o indivíduo que estiver selecionado.
        /// </summary>
        /// <typeparam name="T">Tipo do indivíduo.</typeparam>
        /// <param name="populacao">População</param>
        /// <param name="quantidade">Quantidade a ser selecionado</param>
        /// <returns></returns>
        public static PopulacaoAvaliada<T> Estocastica<T>(PopulacaoAvaliada<T> populacao, int quantidade) 
            where T : Individuo
        {
            return SelecaoPorRoda(SorteioEstocastico, populacao, quantidade);
        }

        private static PopulacaoAvaliada<T> SelecaoPorRoda<T>(SortearSomas<T> sorteio, PopulacaoAvaliada<T> populacao, 
            int quantidade) where T : Individuo
        {
            if (populacao == null) 
                throw new ArgumentException("A população não pode ser nula!");
            
            if (populacao.Count == 0) 
                throw new ArgumentException("A população não pode ser vazia!");
           
            if (quantidade <= 0) {
                throw new ArgumentException("Quantidade inválida!");
            }
                    
            IList<ulong> resultados = sorteio(quantidade, populacao);

            PopulacaoAvaliada<T> selecionados = new PopulacaoAvaliada<T>();
            ulong sum = 0;
            foreach (Avaliado<T> individuo in populacao) {
                sum += individuo.Pontuacao;
                while (resultados.Count > 0 && resultados[0] < sum) {
                    selecionados.Adicionar(individuo);
                    resultados.RemoveAt(0);
                }
            }

            return selecionados;
        }

        private static IList<ulong> SorteioRodaSorte<T>(int quantidade, PopulacaoAvaliada<T> populacao) where T : Individuo
        {
            Random r = new Random();
            ulong soma = populacao.Soma;

            IList<ulong> resultados = new List<ulong>();
            while (resultados.Count < quantidade)
                resultados.Add((ulong) r.NextDouble() * soma);

            return (from resultado in resultados
                   orderby resultado
                   select resultado).ToList();

        }

        private static IList<ulong> SorteioEstocastico<T>(int quantidade, PopulacaoAvaliada<T> populacao) where T : Individuo
        {
            double division = populacao.Soma / (double)quantidade;
            IList<ulong> somas = new List<ulong>();
            for (int i = 0; i < quantidade; i++)
                somas.Add((ulong)(i * division));

            return somas;
        }

        /// <summary>
        /// Representa o processo de torneio com 2 indivíduos.
        /// </summary>
        /// <typeparam name="T">Tipo do indivíduo.</typeparam>
        /// <param name="populacao">População</param>
        /// <param name="quantidade">Quantidade a ser selecionado</param>
        /// <returns>Os indivíduos selecionados</returns>
        /// <seealso cref="SelecaoAssintotica"/>
        public static PopulacaoAvaliada<T> Assintotica<T>(PopulacaoAvaliada<T> populacao, int quantidade)
            where T : Individuo
        {
            return new Torneio<T>(2).Selecionar(populacao, quantidade);
        }

    }
}
