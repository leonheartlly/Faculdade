using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils.Geral.Genetic.Domain
{
    /**
     * Um indivíduo representa um objeto específico de domínio, e encapsula
     * a lógica de lidar com a estrutura de seu genoma.
     */
    public interface Individuo
    {
        /**
         * Cruza esse indivíduo com outro, gerando outros filhos (normalmente dois).
         * Os dois indivíduos retornados devem ser da mesma classe.
         * @param other O outro indivíduo para fazer a cruza.
         * @return Os filhos
         */
        IList<Individuo> Cruzar(Individuo other);

        /**
         * Faz a mutação sobre o indivíduo.
         */
        void Mudar();
    }
}
