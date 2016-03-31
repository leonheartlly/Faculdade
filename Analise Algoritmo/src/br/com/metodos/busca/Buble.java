package br.com.metodos.busca;

public class Buble {
	
	public static void Bubble(long vetor[]){ 
		int i, j;
		long aux;

		

		for (j = 1; j <= vetor.length; j++) {
			for (i = 0; i <= vetor.length - 2; i++) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
				}
			}
			
		}

		
	}	
	
}
