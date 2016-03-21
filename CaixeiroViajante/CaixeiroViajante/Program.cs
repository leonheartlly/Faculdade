using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic;
using Utils.Geral.Genetic.Scaling;
using Utils.Geral.Genetic.Selection;

namespace CaixeiroViajante
{
    /// <summary>
    /// Demonstração da API de algorítmos genéticos.
    /// Esse programa tenta resolver o problema do caixeiro viajante usando GAs.
    /// 
    /// Cada cidade é representada por um vetor matemático. 
    /// O custo é a distância entre as cidades.
    /// 
    /// Assume-se que o caixeiro possa viajar de qualquer cidade para qualquer cidade em linha reta.
    /// O programa deve apenas definir a ordem que isso ocorre.
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            //Cidades a serem usadas no programa
            IList<Cidade> cidades = new List<Cidade>();
            cidades.Add(new Cidade("Curitiba", 326, 221));
            cidades.Add(new Cidade("Ponta grossa", 280, 187));
            cidades.Add(new Cidade("Telêmaco Borba", 252, 150));
            cidades.Add(new Cidade("Guarapuava", 205, 215));
            cidades.Add(new Cidade("Pato Branco", 141, 263));
            cidades.Add(new Cidade("Cascavel", 96, 185));            
            cidades.Add(new Cidade("Foz do Iguaçu", 38, 220));
            cidades.Add(new Cidade("Umuarama", 105, 110));            
            cidades.Add(new Cidade("Paranavaí", 152, 71));
            cidades.Add(new Cidade("Apucarana", 182, 96));
            cidades.Add(new Cidade("Maringá", 208, 97));
            cidades.Add(new Cidade("Londrina", 226, 85));

            DateTime before = DateTime.Now;
            //Geração da população inicial            
            IList<Rota> populacaoInicial = new List<Rota>();
            for (int i = 0; i < 1000; i++)
                populacaoInicial.Add(Rota.random(cidades));

            //Criamos a geração inicial            
            Geracao<Rota> geracao = new Geracao<Rota>(
                populacaoInicial,                               //População inicial
                Rota.avaliar,                                   //Função de fitness
                FuncoesEscala.SemEscala,                        //Função de escala
                new SelecaoAssintotica<Rota>(1.2).Selecionar,   //Função de seleção
                0.75,                                           //Taxa de cruzamento
                0.05,                                           //Taxa de mutação
                0.01);                                          //Taxa de elitismo

            //Avançamos 500 gerações            
            Geracao<Rota> milesima = geracao.Proxima(500);
            TimeSpan elapsedTime = DateTime.Now - before;

            Console.Out.WriteLine("A ordem das cidades é:");
            foreach (Cidade cidade in milesima.MelhorIndividuo.Cidades)
                Console.Out.WriteLine(cidade.Nome);
            Console.Out.WriteLine("A distância total percorrida será: " + (uint.MaxValue - milesima.PontuacaoDoMelhorIndividuo));            
            Console.Out.WriteLine(String.Format("Calculado em: {0:0.00}s", elapsedTime.TotalSeconds));
            Console.Out.WriteLine("Pressione qualquer tecla para continuar...");
            Console.ReadKey();
        }
    }
}
