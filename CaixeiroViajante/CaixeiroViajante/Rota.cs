using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;
using System.Collections.ObjectModel;
using MathPhysics;

namespace CaixeiroViajante
{
    public class Rota : Individuo
    {
        private static Random RND = new Random();
        
        IList<Cidade> cidades;

        #region Individuo Members

        private Rota(IList<Cidade> _cidades)            
        {
            cidades = new List<Cidade>(_cidades);            
        }

        public static Rota random(IList<Cidade> _cidades)
        {
            IList<Cidade> cidades = new List<Cidade>(_cidades);
            cidades.Shuffle();
            return new Rota(cidades);
        }

        public IList<Cidade> Cidades
        {
            get
            {
                return new ReadOnlyCollection<Cidade>(cidades);
            }
        }

        /// <summary>
        /// Processo de cruzamento. 
        /// Funciona da seguinte forma:
        /// 1. Escolhe-se um ponto de cruzamento
        /// 2. Localiza a rota da cidade e do vizinho no pai A
        /// 3. Remove as mesmas cidades no pai B
        /// 4. Re-adiciona em B no mesmo local onde elas aparecem em A
        /// O mesmo processo é feito para os dois pais.
        /// 
        /// Exemplo:
        /// Pais:
        /// X: A B C D E F
        /// Y: B C A D F E
        /// 
        /// 1. Escolhe-se um ponto de cruzamento: 2
        /// X: A C D B E F  -- 2. Cidades nos índices 2 e 3 = C e D
        /// Y: B A F E      -- 3. Remoção de C e D em Y
        /// Y: B A C D F E  -- 4. Readiciona C e D em Y nos mesmos índices de X
        ///
        /// Y: B C A D F E  -- 2. Cidades nos índices 2 e 3 = A e D
        /// X: B C E F      -- 3. Remoção de A e D em X
        /// X: B C A D E F  -- 4. Readiciona A e D em X nos mesmos índices de Y
        ///         
        public IList<Individuo> Cruzar(Individuo other)
        {            
            //Copia a ordem            
            IList<Cidade> outro = ((Rota)other).cidades;
            IList<Cidade> filho1 = new List<Cidade>(cidades);
            IList<Cidade> filho2 = new List<Cidade>(outro);

            //Seleciona um ponto para o cruzamento
            int point = RND.Next(cidades.Count - 1);

            //Esse if evita a movimentação caso seja desnecessária
            if (filho1[point] != filho2[point] || filho1[point + 1] != filho2[point + 1])
            {
                filho1.Remove(outro[point + 1]);
                filho1.Remove(outro[point]);
                filho1.Insert(point, outro[point + 1]);
                filho1.Insert(point, outro[point]);

                filho2.Remove(cidades[point+1]);
                filho2.Remove(cidades[point]);
                filho2.Insert(point, cidades[point+1]);
                filho2.Insert(point, cidades[point]);
            }

            //Retorna os filhos
            IList<Individuo> filhos = new List<Individuo>(2);
            filhos.Add(new Rota(filho1));
            filhos.Add(new Rota(filho2));
            return filhos;
        }

        /// <summary>
        /// Troca aleatoriamente 2 cidades de lugar
        /// </summary>
        public void Mudar()
        {
            cidades.Swap(RND.Next(cidades.Count), RND.Next(cidades.Count));
        }

        /// <summary>
        /// Função de avaliação da rota. Basta calcular a distância entre as cidades.
        /// Como o melhor escore deve ser dado a menor distância, subtrairemos a 
        /// distância de um número arbitrariamente grande.
        /// </summary>
        /// <param name="rota">A rota a ser calculada</param>
        /// <returns>O escore da rota</returns>

        public static uint avaliar(Rota rota)
        {
            double distancia = 0;
            for (int i = 0; i < rota.Cidades.Count - 1; i++)
            {
                IList<Cidade> cidades = rota.Cidades;
                Vector2D atual = cidades[i].Local;
                Vector2D proxima = cidades[i+1].Local;                
                distancia += (atual - proxima).Size;
            }
            return uint.MaxValue - (uint)distancia;
        }
        #endregion
    }
}
