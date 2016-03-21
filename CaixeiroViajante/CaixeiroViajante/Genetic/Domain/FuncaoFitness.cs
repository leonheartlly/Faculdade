using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils.Geral.Genetic.Domain
{
    /// <summary>
    /// Calcula o valor de fitness. Para um dado indivíduo, essa função fornece uma pontuação.
    /// Quanto mais alta essa pontuação, mais próximo o individuo deve estar da resolução ideal 
    /// do problema.
    /// </summary>
    /// <typeparam name="T">O tipo do indivíduo</typeparam>
    /// <param name="individual">O indivíduo que será avaliado</param>
    /// <returns>O escore daquele indivíduo (quanto maior melhor)</returns>
    public delegate uint FuncaoFitness<T>(T individual) where T : Individuo;
}
