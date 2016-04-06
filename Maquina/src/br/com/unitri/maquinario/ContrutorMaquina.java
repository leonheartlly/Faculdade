package br.com.unitri.maquinario;
import java.util.Scanner;
import java.util.Vector;

public class ContrutorMaquina
{
	public Maquina getMaquina(Scanner scan)
	{
		int numComeco = 0; // 1 no final

		Vector<Estado> Q = new Vector<Estado>(), F = new Vector<Estado>();
		Vector<Character> alfabeto = new Vector<Character>();
		Estado inicial = new Estado(null);

		while (scan.hasNext())
		{
			String linha = scan.nextLine();

			if (linha.startsWith(Maquina.INDICADOR_INICIAL))
			{
				numComeco++;

				if (numComeco > 1)
				{
					break;
				}	
				else
				{
					linha = linha.substring(Maquina.INDICADOR_INICIAL.length());

					inicial = getEstadoDaLinha(Q, linha);
				}
			}
			else if (linha.startsWith(Maquina.INDICADOR_FINAL))
			{
				linha = linha.substring(Maquina.INDICADOR_FINAL.length());

				F.add(getEstadoDaLinha(Q, linha));
			}	
			else
				leitorTransicao(Q, alfabeto, linha);
		}

		Maquina machine = new Maquina(Q, alfabeto, inicial, F);

		if (numComeco != 1)
			machine = null;

		return machine;
	}

	private Estado  leitorTransicao(Vector<Estado> Q, Vector<Character> alfabeto,
			String linha)
	{
		Scanner scan = new Scanner(linha);

		Estado estado = getEstadoDoVetor(Q, new Estado(scan.next()));
		char transicao = getCharDoAfabeto(alfabeto, scan.next().charAt(0));
		Estado nextState = getEstadoDoVetor(Q, new Estado(scan.next()));

		estado.addTransicao(transicao, nextState);
		scan.close();
		return estado;
	}
	
	private Estado getEstadoDaLinha(Vector<Estado> Q, String linha)
	{
		Scanner scan = new Scanner(linha);

		Estado estado = getEstadoDoVetor(Q, new Estado(scan.next()));
		scan.close();
		return estado;
	}

	/* Se um estado equivalente estiver em estados, este estado é retornado,
	 * do contrario o estado é adicionado à estados e entao retornado. De qualquer forma,
	 * o que é retornado é um elemento de estados.
	 */
	private Estado getEstadoDoVetor(Vector<Estado> estados, Estado estado)
	{
		Estado encontrado = new Estado(null);

		if (!estados.contains(estado))
			estados.add(estado);

		encontrado = estados.get(estados.indexOf(estado));

		return encontrado;
	}

	private char getCharDoAfabeto(Vector<Character> alphabet, char ch)
	{
		if (!alphabet.contains(ch))
			alphabet.add(ch);

		return ch;
	}
}
