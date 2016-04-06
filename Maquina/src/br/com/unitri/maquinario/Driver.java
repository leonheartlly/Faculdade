package br.com.unitri.maquinario;


/* Driver.java: driver class for the DFA minimization program.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		ContrutorMaquina construtor = new ContrutorMaquina();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Entre o nome do arquivo: ");
		String nomeArquivo = scan.nextLine();
		
		Maquina maquina = null;
		
		try
		{
			maquina = construtor.getMaquina(new Scanner(new File(nomeArquivo)));
			System.out.println("Lendo em:\n" + maquina);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Arquivo nao encontrado.");
			System.exit(1);
		}
		
		maquina = Minimizador.minimiza(maquina);
		
		System.out.println("Maquina Minimizada:\n" + maquina);
		scan.close();
	}
}
