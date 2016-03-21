using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;

namespace Utils.Geral.Genetic
{
    public class Avaliado<T> where T : Individuo
    {
        private T _individuo;
        private uint _pontuacao;

        public Avaliado(T individuo, uint pontuacao) {
            if (individuo == null) 
                throw new ArgumentException("Indivíduo inválido!");

            _individuo = individuo;
            _pontuacao = pontuacao;
        }

        public Avaliado(T individuo, FuncaoFitness<T> funcaoFitness)
            : this(individuo, funcaoFitness(individuo))
        {            
        }

        public uint Pontuacao
        {
            set
            {
                _pontuacao = value;
            }

            get
            {
                return _pontuacao;
            }

        }

        public T Individuo
        {
            get
            {
                return _individuo;
            }
        }    
    }
}
