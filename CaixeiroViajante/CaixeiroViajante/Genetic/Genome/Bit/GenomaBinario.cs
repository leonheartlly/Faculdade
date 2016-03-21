using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace Utils.Geral.Genetic.Genome.Bit
{
    
    /// <summary>
    /// Representa um genome, com genes codificados na forma de dados binários.
    /// Fornece métodos úteis para definir e ler valores na cadeia binária. Também
    /// fornece mecanismos para cruzamento e mutação.
    /// </summary>
    public class GenomaBinario
    {
        /// <summary>
        /// Altera o genoma de acordo com algum critério de mutação.
        /// </summary>
        /// <param name="genome">O genoma a ser alterado</param>
        public delegate void FuncaoDeMutacao(GenomaBinario genoma);
        public delegate KeyValuePair<GenomaBinario, GenomaBinario> FuncaoDeCruzamento(GenomaBinario genoma, GenomaBinario outro);

        private static Random random = new Random();
        private BitArray genes;

        /// <summary>
        /// Cria um novo genoma com N bits de tamanho.        
        /// </summary>
        /// <param name="tamanho">Tamanho do genoma</param>
        public GenomaBinario(int tamanho)
        {
            genes = new BitArray(tamanho);
        }        

        /// <summary>
        /// Cria um novo genoma com conteúdo aleatório
        /// </summary>
        /// <param name="tamanho">Tamanho do genoma</param>
        /// <returns>Um genoma com bits aleatoriamente definidos em 1</returns>
        public static GenomaBinario CriarAleatorio(int tamanho)
        {
            
            GenomaBinario genes = new GenomaBinario(tamanho);
            for (int i = 0; i < genes.Count; i++)
                genes[i] = random.Next(2) == 0;
            return genes;
        }

        /// <summary>
        /// Cria um novo genoma com vários bits, porém, com um número fixo deles 
        /// aleatoriamente definidos em 1. Por exemplo, um genoma com 100 bits onde
        /// só 20 estejam definidos como 1.
        /// </summary>
        /// <param name="tamanho">Tamanho do genoma</param>
        /// <param name="qtdeLigados">Número de bits inicialmente ligado</param>
        /// <returns>O genoma criado</returns>
        public static GenomaBinario CriarAleatorio(int tamanho, int qtdeLigados)
        {
            GenomaBinario genes = new GenomaBinario(tamanho);

            IList<int> numeros = new List<int>(tamanho);
            for (int i = 0; i < tamanho; i++)
                numeros[i] = i;

            numeros.Shuffle(random);
            for (int i = 0; i < qtdeLigados; i++)
                genes[numeros[i]] = true;

            return genes;
        }

        /// <summary>
        /// Define o número dado, na posição especificada, usando count bits.
        /// </summary>
        /// <param name="pos">Posição para definir o número</param>
        /// <param name="numero">Número a ser definido. O número deve estar no intervalo entre 0 até 2^bits-1.</param>
        /// <param name="bits">Número de bits usado para armazenar o número</param>
        public void SetUnsigned(int pos, long numero, int bits)
        {
            int max = ((2 << bits - 1) - 1);

            if (numero > max)
                throw new ArgumentException("Número inválido " + numero + "! O número máximo para " + bits + " bits é " + max + "!");

            if (numero < 0)
                throw new ArgumentException("Números sem sinal não podem ser menores que 0!");

            for (int i = pos + bits - 1; i >= pos; i--)
            {
                genes[i] = (numero & 1) == 1;
                numero = numero >> 1;
            }
        }

        /// Define o número com sinal dado, na posição especificada, usando count bits.
        /// <param name="pos">Posição para definir o número</param>
        /// <param name="numero">Número a ser definido. O número deve estar no intervalo entre 0 até 2^(bits-1)-1.</param>
        /// <param name="bits">Número de bits usado para armazenar o número</param>
        public void SetSigned(int pos, long number, int bits)
        {
            if (number < 0)
            {
                SetUnsigned(pos + 1, -number, bits - 1);
                genes.Set(pos, true);
                return;
            }

            SetUnsigned(pos + 1, number, bits - 1);
            genes.Set(pos, false);
        }

        /// <summary>
        /// Retorna um grupo de bits como um número, iniciando na posição dada.
        /// </summary>
        /// <param name="pos">Posição para do número</param>
        /// <param name="bits">Quantidade de bits do número</param>
        /// <returns>Um número positivo</returns>
        public long GetUnsigned(int pos, int bits)
        {
            long num = 0;

            for (int i = pos; i < pos + bits; i++)
            {
                num = (num << 1) + (genes[i] ? 1 : 0);
            }
            return num;
        }

        /// <summary>
        /// Retorna um grupo de bits como um número, iniciando na posição dada.
        /// </summary>
        /// <param name="pos">Posição para do número</param>
        /// <param name="bits">Quantidade de bits do número. </param>
        /// <returns>O número, o primeiro bit será considerado de sinal.</param>         
        public long GetSigned(int pos, int bits)
        {
            long num = GetUnsigned(pos + 1, bits - 1);
            return genes[pos] ? -num : num;
        }

        /// <summary>
        /// Define o bit específico para um determinado valor. 
        /// O operador de [] pode ser usado para o mesmo fim.
        /// </summary>
        /// <param name="bit">Índice do bit para definir</param>
        /// <param name="valor">Valor</param>
        public void Set(int bit, bool valor)
        {
            genes.Set(bit, valor);
        }

        /// <summary>
        /// Retorna o valor de um determinado bit.
        /// O operador de [] pode ser usado para o mesmo fim. 
        /// </summary>
        /// <param name="bit">Bit Índice a ser recuperado</param>
        /// <returns>O valor do bit</returns>
        public bool Get(int bit)
        {
            return genes[bit];
        }

        public bool this[int bit]
        {
            get
            {
                return genes[bit];
            }
            set
            {
                genes[bit] = value;
            }
        }

        /// <summary>
        /// Faz o cruzamento desse genoma com outro.  
        /// </summary>
        /// <param name="outro">O genoma que será cruzado. </param>
        /// <param name="funcaoDeCruzamento">Um método para cruza.</param>
        /// <returns>Dois genomas com os genes cruzados.</returns>
        /// <seealso cref="GenomaBinario.FuncaoDeCruzamento"/>
        public KeyValuePair<GenomaBinario, GenomaBinario> Cruzar(GenomaBinario outro, FuncaoDeCruzamento funcaoDeCruzamento)
        {
            if (outro == this)
                throw new ArgumentException("Forneça um genoma diferente para o cruzamento!");
            
            if (genes.Count != outro.genes.Count)
                throw new ArgumentException("Genomas incompatíveis!");
            
            return funcaoDeCruzamento(this, outro);
        }

        /// <summary>
        /// Troca alguns bits, fazendo o genoma mudar. 
        /// A política de troca é especificada pela função de mutação recebida.
        /// </summary>
        /// <param name="funcaoDeMutacao">Define a forma que os bits irão mudar.</param>
        public void Mudar(FuncaoDeMutacao funcaoDeMutacao)
        {
            funcaoDeMutacao(this);
        }

        /// <summary>
        /// Retorna o tamanho do genoma, em bits.
        /// </summary>
        public int Count
        {
            get
            {
                return genes.Count;
            }            
        }
    }

}
