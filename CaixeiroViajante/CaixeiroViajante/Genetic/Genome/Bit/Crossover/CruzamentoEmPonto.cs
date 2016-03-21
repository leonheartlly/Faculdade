using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils.Geral.Genetic.Genome.Bit.Crossover
{
    /// <summary>
    /// Implementa um cruzamento em cortes com n-pontos.
    /// <example>
    /// </example>
    /// O genoma 0000000 combinado com 1111111 com cortes em 2 and 5 vai gerar duas proles:
    /// <p>
    /// pai 1 - 00|000|00 <br>
    /// pai 2 - 11|111|11 <br>
    /// <p>
    /// filho1 - 0011100
    /// filho2 - 1100011
    /// </summary>
    public class CruzamentoEmPonto
    {
        private ISet<int> cortes = new HashSet<int>();

        /// <summary>
        /// Cria um novo cruzamento em cortes com n-pontos.
        /// <example>
        /// </example>
        /// O genoma 0000000 combinado com 1111111 com cortes em 2 and 5 vai gerar duas proles:
        /// <p>
        /// pai 1 - 00|000|00 <br>
        /// pai 2 - 11|111|11 <br>
        /// <p>
        /// filho1 - 0011100
        /// filho2 - 1100011
        /// </summary>
        /// <param name="cortes">Posição dos cortes.</param>
        public CruzamentoEmPonto(IEnumerable<int> cortes)
        {
            this.cortes = new HashSet<int>(cortes);

            if (this.cortes.Count == 0)
                throw new ArgumentException("Provide at least one cut!");
        }

        public CruzamentoEmPonto(params int[] cortes) :
            this(new HashSet<int>(cortes))
        {
        }

        /// <summary>
        /// Implementação do Delegate GenomaBinario.FuncaoDeCruzamento.
        /// </summary>
        public KeyValuePair<GenomaBinario, GenomaBinario> Cruzar(GenomaBinario gene1, GenomaBinario gene2)
        {
            KeyValuePair<GenomaBinario, GenomaBinario> misturas = new KeyValuePair<GenomaBinario, GenomaBinario>(
                new GenomaBinario(gene1.Count), new GenomaBinario(gene2.Count));

            bool flip = false;

            for (int i = 0; i < gene1.Count; i++)
            {
                if (cortes.Contains(i))
                    flip = !flip;

                misturas.Key[i] = flip ? gene1[i] : gene2[i];
                misturas.Value[i] = flip ? gene2[i] : gene1[i];
            }

            return misturas;
        }
    }
}
