package br.com.analiseAlgoritmo.caçaPalavra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CacaBruta {

	static ArrayList<String> lines;
	static String palavra = "computação";
	static int line = 0;
	static int contem = 0;
	static String palavras[] = new String[10000000];

	public static String buscaBruta() throws IOException {

		File file = new File(
				"C:\\Users\\Lucas\\Desktop\\LogsOMU\\Trabalho 1berto\\texto.txt");
		BufferedReader reader = null;
		 StringBuilder conteudoTXT = new StringBuilder();
		lines = new ArrayList<String>();

		if (file.exists()) {

			try {

				reader = new BufferedReader(new FileReader(file));

				while (reader.ready()) {
					lines.add(reader.readLine() + "\n");
				}
				reader.close();

			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}
		}
		return lines.toString();

	}

	public static void buscaSequencia() throws IOException {
		
		buscaBruta();
		long tempoInicial = System.currentTimeMillis();         
		int controla = 0;
		for (String frase : lines) {
			
			StringTokenizer st = new StringTokenizer(frase);
			
			while (st.hasMoreTokens()) {

				String toc = st.nextToken().toLowerCase();
				
				palavra = palavra.toLowerCase();
				
				for (int i = 0; i < toc.length(); i++) {
					
					boolean bol = true;
					
					if (toc.charAt(i) == palavra.charAt(0)) {
						
						int k = i, y = 0;
						
						while (y < palavra.length() && k < toc.length()) {
							
							if (toc.charAt(k) == palavra.charAt(y)) {
								
							} else {
								
								bol = false;
								
								break;
							}
							k++;
							y++;
						}
						
						if (bol  && y >= palavra.length()) {
							
							contem++;
							
							palavras[controla++] = toc;
						}
						
					}
				}
			}
		}
		long tempoFinal = System.currentTimeMillis();
		
		for (int i = 0; i <= controla -1; i++) {
			
			System.out.print(palavras[i]+", ");
		}
		System.out.println("\nquantidade: " + contem);
		System.out.println("Tempo: "+(tempoFinal - tempoInicial)+" m/s");
	}

	public static void main(String[] args) throws IOException {
		String textoHP;
		int HPcont = 0;
		buscaSequencia();
		
		textoHP = buscaBruta().toLowerCase();
		palavra = palavra.toLowerCase();
		long tempoInicial = System.currentTimeMillis();
		List<Integer> matches = new Horspool().match(palavra, textoHP);
		System.out.println("\n");
 		for (Integer integer : matches) {
 			HPcont++;
 			System.out.print("Posição:  "+ integer +", ");
 		}
 		long tempoFinal = System.currentTimeMillis();
 		
 		System.out.println("\nQuantidade : "+HPcont);
 		System.out.println("Tempo: "+(tempoFinal - tempoInicial)+" m/s");
	}
}
