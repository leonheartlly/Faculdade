using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils.Geral.Genetic.Genome.Bit.Mutation
{
    public class MutacaoAleatoria
    {
        private double taxaPorBit;

        public MutacaoAleatoria(double taxaPorBit)
        {
            if (taxaPorBit <= 0 || taxaPorBit >= 1) {
                throw new ArgumentException("A taxa por bit deve ser entre 0 e 1!");
            }

            this.taxaPorBit = taxaPorBit;
        }

        public void Mudar(GenomaBinario genes) {
            if (taxaPorBit == 0)
                return;

            Random random = new Random();
            for (int i = 0; i < genes.Count; i++) {
                if (random.NextDouble() <= taxaPorBit) {
                    genes[i] = !genes[i];
                }
            }
        }
    }
}
