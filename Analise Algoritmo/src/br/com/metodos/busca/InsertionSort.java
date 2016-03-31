package br.com.metodos.busca;

public class InsertionSort {
	
	public static void Insertion(long vetor[]) {
		int i, j;
		long eleito;
		
		
		for (i = 1; i < vetor.length; i++) {
			eleito = vetor[i];
			j = i - 1;
			while (j >= 0 && vetor[j] > eleito) {
				vetor[j + 1] = vetor[j];
				j = j - 1;
			}
			vetor[j + 1] = eleito;
		}
		
		int k=0;
		for(i = 0;i<10;i++){
			
			System.out.println(vetor[k]);
			k++;
		}
		
	}

}
