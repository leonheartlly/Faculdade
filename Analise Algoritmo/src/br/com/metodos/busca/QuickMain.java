package br.com.metodos.busca;

public class QuickMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuickSort quick = new QuickSort();
		
		long vet[] = {0,9,5,7,3};
		int ini, fim;
		ini = 0;
		fim = 4;
		quick.quickSort(vet, ini, fim);
		
	}

}
