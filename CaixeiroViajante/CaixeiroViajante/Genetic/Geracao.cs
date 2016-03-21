using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils.Geral.Genetic.Domain;
using Utils.Geral.Genetic.Scaling;
using Utils.Geral.Genetic.Selection;

namespace Utils.Geral.Genetic
{
    public class Geracao<T> where T : Individuo
    {
        private static Random random = new Random();

	    private int numero;
	    private PopulacaoAvaliada<T> avaliados = new PopulacaoAvaliada<T>();
	    private FuncaoFitness<T> funcaoFitness;
	    private FuncaoEscala<T> funcaoEscala;
	    private FuncaoSelecao<T> funcaoSelecao;
	    private double taxaCruzamento;
	    private double taxaElitismo;
	    private double taxaMutacao;

	    /**
	     * Create a new generation using the above defaults:
	     * <ul>
	     * <li>No scaling;
	     * <li>Roulette wheel selection
	     * <li>75% crossover rate;
	     * <li>100% mutation rate (the mutation rate should be defined by the
	     * genome);
	     * <li>5% elitism;
	     * </ul>
	     * 
	     * @param population
	     * @param fitnessFunction
	     */
        
        /// <summary>
        /// Cria uma nova geração usando os padrões abaixo:
        /// a) Sem escala;
        /// b) Seleção assintótica com expoente 1.1;
        /// c) 75% de taxa de cruzamento
        /// d) 100% de taxa de mutação (o genome deve restringir essa taxa).
        /// e) 5% de elitismo
        /// </summary>
        /// <param name="populacao">População inicial</param>
        /// <param name="funcaoFitness">Função de fitness</param>
	    public Geracao(IList<T> populacao,
			    FuncaoFitness<T> funcaoFitness) :
		    this(populacao, funcaoFitness, FuncoesEscala.SemEscala,
                FuncoesSelecao.Assintotica, 0.75, 1, 0.05)
        {
	    }

	    /**
	     * Construtor da próxima geração
	     */
	    private Geracao(IList<T> population, Geracao<T> other) 
            : this(population, other.funcaoFitness, other.funcaoEscala,
				    other.funcaoSelecao, other.taxaCruzamento,
				    other.taxaMutacao, other.taxaElitismo)

        {
		    numero = other.numero + 1;
	    }

        /// <summary>
        /// Cria uma nova geração.
        /// </summary>
        /// <param name="populacao">População inicial</param>
        /// <param name="funcaoFitness">Função de fitness</param>
        /// <param name="funcaoEscala">Função de escala</param>
        /// <param name="funcaoSelecao">Função de seleção</param>
        /// <param name="taxaCruzamento">Taxa de cruzamento</param>
        /// <param name="taxaMutacao">Taxa de mutação</param>
        /// <param name="taxaElitismo">Taxa de elitismo</param>
	    public Geracao(IList<T> populacao,
			    FuncaoFitness<T> funcaoFitness,
			    FuncaoEscala<T> funcaoEscala,
			    FuncaoSelecao<T> funcaoSelecao, double taxaCruzamento,
			    double taxaMutacao, double taxaElitismo) {

		    if (populacao == null) 
			    throw new ArgumentException("População inicial inválida!");
		    
		    if (funcaoFitness == null) 
			    throw new ArgumentException("Função de fitness inválida!");
		    
		    if (funcaoEscala == null) 
			    throw new ArgumentException("Função de escala inválida!");
		    
		    if (funcaoSelecao == null) 
			    throw new ArgumentException("Função de seleção inválida!");

		    if (taxaCruzamento < 0 || taxaCruzamento > 1) 
			    throw new ArgumentException("A taxa de cruzamento deve ser entre 0 e 1!");
		    
		    if (taxaElitismo < 0 || taxaElitismo > 0.7) 
			    throw new ArgumentException("A taxa de elitismo deve ser entre 0 e 0.7!");
		    

		    this.numero = 0;
		    this.funcaoFitness = funcaoFitness;
		    this.funcaoEscala = funcaoEscala;
		    this.funcaoSelecao = funcaoSelecao;
		    this.taxaCruzamento = taxaCruzamento;
		    this.taxaElitismo = taxaElitismo;
		    this.taxaMutacao = taxaMutacao;
		    this.numero = 0;

            RealizarCalculos(populacao);
	    }

	    public T MelhorIndividuo 
        {
            get
            {
		        return avaliados.Melhor.Individuo;
            }
	    }

	    public uint PontuacaoDoMelhorIndividuo
        {
            get
            {
		        return avaliados.Melhor.Pontuacao;
            }
	    }

	    private void RealizarCalculos(IList<T> population) {
		    foreach (T individuo in population) {
			    avaliados.Adicionar(new Avaliado<T>(individuo, funcaoFitness));
		    }
		    avaliados.Sort();
	    }

        public Geracao<T> Proxima(int count)
        {
            Geracao<T> generation = this;
            for (int i = 0; i < count; i++)
                generation = generation.Proxima();

            return generation;
        }
	    
	    public Geracao<T> Proxima() {
		    IList<T> next = new List<T>();

		    // Separa a elite. Se a taxa > 0, pelo menos 1 indivíduo sempre constituirá a elite.
            int eliteSize = taxaElitismo == 0 ? 0 : Math.Max(1, (int)(taxaElitismo * avaliados.Count));
            for (int i = 0; i < eliteSize; i++)
                next.Add(avaliados[i].Individuo);
		    
		    // Escala a população remanescente
		    PopulacaoAvaliada<T> scaled = funcaoEscala(avaliados);

		    // Seleciona os candidatos para o cruzamento
		    PopulacaoAvaliada<T> selected = funcaoSelecao(scaled, scaled.Count - eliteSize);

		    // Para cada par selecionado
		    int j = 0;
		    while (next.Count < Count) {
			    T p1 = selected[j].Individuo;
			    T p2 = selected[j + 1].Individuo;
			    j = (j+2) % (selected.Count-1);

			    IList<T> children = new List<T>();			    
			    // Faz o cruzamento da seleção, de acordo com a taxa de cruzamento
			    if (random.NextDouble() < taxaCruzamento) {
                    IList<Individuo> filhos = p1.Cruzar(p2);
                    foreach (Individuo filho in filhos)
                        children.Add((T)filho);                    				                    
			    } else {
				    children.Add(p1);
				    children.Add(p2);
			    }

			    // Faz a mutação na seleção, se necessário
			    foreach (T child in children) 
				    if (random.NextDouble() < taxaMutacao) 
					    child.Mudar();

			    //Finalmente, adiciona os elementos a lista de retorno.
			    foreach (T child in children)
				    next.Add(child);			
		    }

		    return new Geracao<T>(next, this);
	    }

	    private int Count 
        {
            get
            {
                return avaliados.Count;
            }		    
	    }

        public int Numero
        {
            get
            {
                return numero;
            }
        }

    }
}
