using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils.Geral.Genetic.Genome.Bit.Crossover
{
    public class CruzamentoUniforme
    {
        private double taxaPorBit;

        /// <summary>
        /// Cruza aleatoriamente os bits dos pais.
        /// Um número aletório entre 0 e 1 é sorteado. Se for menor que a taxa por bit,
        /// então o bit do pai e da mãe será trocado. Uma taxa muito grande ou muito pequena
        /// irá ter altas chances de gerar filhos idênticos aos pais.
        /// </summary>
        /// <param name="taxaPorBit">Chance de cruzar um único bit.</param>
        public CruzamentoUniforme(double taxaPorBit)
        {
            if (taxaPorBit <= 0 || taxaPorBit >= 1)
                throw new ArgumentException("A taxa de cruzamento por bit deve ser entre 0 e 1!");

            this.taxaPorBit = taxaPorBit;
        }

        public KeyValuePair<GenomaBinario, GenomaBinario> Cruzar(GenomaBinario genome1, GenomaBinario genome2)
        {
            Random random = new Random();
            KeyValuePair<GenomaBinario, GenomaBinario> children = new KeyValuePair<GenomaBinario, GenomaBinario>(
                new GenomaBinario(genome1.Count), new GenomaBinario(genome2.Count));

            for (int i = 0; i < genome1.Count; i++)
                if (random.NextDouble() <= taxaPorBit)
                {
                    children.Key[i] = genome2[i];
                    children.Value[i] = genome1[i];
                }
                else
                {
                    children.Key[i] = genome1[i];
                    children.Value[i] = genome2[i];
                }
            return children;
        }
    }
}
