package br.com.metodos.busca;

public class MergeSort {
	

	public static void Merge(long vetor[], int inicio, int fim) {
		int meio;

		if (inicio < fim) {
			meio = (inicio + fim) / 2;
			Merge(vetor, inicio, meio);
			Merge(vetor, meio + 1, fim);
			intercala(vetor, inicio, fim, meio);
		}

			}

	public static void intercala(long vetor[], int inicio, int fim, int meio) {
		int poslivre = inicio, iniciovetor1 = inicio, iniciovetor2 = meio + 1, i;
		long aux[] = new long[vetor.length];
		while (iniciovetor1 <= meio && iniciovetor2 <= fim) {
			if (vetor[iniciovetor1] <= vetor[iniciovetor2]) {
				aux[poslivre] = vetor[iniciovetor1];
				iniciovetor1++;
			} else {
				aux[poslivre] = vetor[iniciovetor2];
				iniciovetor2++;
			}
			poslivre++;
		}
		for (i = iniciovetor1; i <= meio; i++) {
			aux[poslivre] = vetor[i];
			poslivre++;
		}
		for (i = iniciovetor2; i <= fim; i++) {
			aux[poslivre] = vetor[i];
			poslivre++;
		}
		for (i = inicio; i <= fim; i++) {
			vetor[i] = aux[i];
		}
	}
	
}
