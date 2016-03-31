package br.com.analiseAlgoritmo.forcaBruta;

import br.com.metodos.busca.QuickSort;

public class quickSearch {

	existeVar eV;

	public void quickFindAlg() {
		eV.tempoInicial = System.currentTimeMillis();
		for (int i = 0; i < eV.vet.length; i++) {
			if (i == eV.vet.length - 1) {
				System.out.print("Nenhum numero se repete no vetor");
				break;
			}
			if (eV.vet[i] == eV.vet[i + 1]) {
				System.out.print("O numero " + eV.vet[i] + " se repete!");
				break;
			}
		}
		eV.tempoFinal = System.currentTimeMillis();
		System.out.println("\nTempo: "
				+ ((eV.tempoFinal + QuickSort.quickT) - eV.tempoInicial)
				+ "/ms");
	}

	public long quickRepete() {
		eV.tempoInicial = System.currentTimeMillis();
		int cont = 1, qtFinal = 0;
		long aux = 0, varFinal = 0;
		for (int i = 0; i < eV.vet.length; i++) {
			if (i == eV.vet.length - 1)
				break;
			if (eV.vet[i] == eV.vet[i + 1]) {
				cont++;
				aux = eV.vet[i];
			} else {
				if (cont > qtFinal) {
					qtFinal = cont;
					varFinal = aux;
				}
				aux = 0;
				cont = 1;
			}
		}
		System.out.println("o numero que se repete mais é: " + varFinal
				+ " repetindo " + qtFinal);
		eV.tempoFinal = System.currentTimeMillis();
		System.out.println("\nTempo: "
				+ ((eV.tempoFinal + QuickSort.quickT) - eV.tempoInicial)
				+ "/ms");
		return varFinal;
	}

	public void  quickChave(){
		eV.tempoInicial = System.currentTimeMillis();
		
		int hasNum = 3;
		boolean achou = false;
		int alto = eV.vet.length-1;
		int baixo = 0;
		int meio = alto/2;
		
		while(!achou && alto >=baixo){
			
			if(hasNum == eV.vet[meio]){
				achou = true;
			}else if(hasNum < eV.vet[meio]){
				alto = meio - 1;
			} else {
				baixo = meio + 1;
			}
			meio = (alto + baixo) / 2;
		}
		
	/*	for(int i = 0; i < eV.vet.length;i++){
			
			if(eV.vet[i]==hasNum){
				System.out.println("O numero "+hasNum+ " se encontra na posição "+eV.vet[i]);
				break;
			}if(i==eV.vet.length-1)
			System.out.println("O numero nao se encontra no Vetor");
		}
		*/
		
		
		if(achou==true){
			System.out.println("\nO numero foi encontrado!");
		}else{
			System.out.println("\nO numero nao se encontra no vetor! ");
		}
		
		eV.tempoFinal = System.currentTimeMillis();
		System.out.println("\nTempo: "
				+ ((eV.tempoFinal + QuickSort.quickT) - eV.tempoInicial)
				+ "/ms");
		
	}
}
