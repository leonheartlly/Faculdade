using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;
using System.Collections.ObjectModel;
using System.Collections;

namespace Utils.Geral.Genetic
{
    public class PopulacaoAvaliada<T> : IEnumerable<Avaliado<T>> where T : Individuo
    {
        private IList<Avaliado<T>> _populacao = new List<Avaliado<T>>();
        private Avaliado<T> _melhor = null;
        private ulong _soma = 0;

        public void Adicionar(Avaliado<T> individuo)
        {
            _populacao.Add(individuo);
            _soma += individuo.Pontuacao;
            if (_melhor == null || individuo.Pontuacao > _melhor.Pontuacao)
                _melhor = individuo;
        }

        public void Adicionar(Avaliado<T> individuo, uint novaPontuacao)
        {
            Adicionar(new Avaliado<T>(individuo.Individuo, novaPontuacao));
        }

        public IList<Avaliado<T>> Population
        {
            get
            {
                return new ReadOnlyCollection<Avaliado<T>>(_populacao);
            }
        }

        public Avaliado<T> Melhor
        {
            get
            {
                return _melhor;
            }
        }

        public ulong Soma
        {
            get
            {
                return _soma;
            }
        }

        public double Media
        {
            get
            {
                return _soma / (double)_populacao.Count;
            }
        }

        public void Sort()
        {
            _populacao = (from avaliado in _populacao
                          orderby avaliado.Pontuacao descending
                          select avaliado).ToList();            
        }

        public int Count
        {   
            get
            {
                return _populacao.Count;
            }
        }

        public Avaliado<T> this[int index]
        {
            get
            {
                return _populacao[index];
            }
        }


        public IEnumerator<Avaliado<T>> GetEnumerator()
        {
            return _populacao.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return _populacao.GetEnumerator();
        }
    }
}
