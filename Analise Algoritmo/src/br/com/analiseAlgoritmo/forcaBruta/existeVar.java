package br.com.analiseAlgoritmo.forcaBruta;

import java.util.Random;

import br.com.metodos.busca.QuickSort;


public class existeVar {
	
	public static long vet[] = new long [2000000];
	public static long tempoInicial = 0;
	public static long tempoFinal = 0;
	public static long quickTempo = QuickSort.quickT;
	public static long provaReal = 0;
	public static long provaReal2 = 0;
	public static int ini = 0,fim = vet.length-1;
	
	public static void randomize(){
		
		
		Random rand = new Random();
		
		for(int i=1; i < vet.length; i++){
			vet[i]=rand.nextInt(20000000); 
		}
		
		
	}
	public static void brutaoVerificaMaisDeUm(){
		
		tempoInicial = System.currentTimeMillis();
		int aux = 1;
		for(int i = 0; i < vet.length;i++){
			for(int j = vet.length-1; j > 0;j--){
			
			if(vet[i]==vet[j]){
				aux++;
					if(aux > 2)
						break;
			}
		}
			if(aux > 2){
				System.out.print("o numero "+vet[i]+" se repete no vetor");
				break;
			}
			if(i==vet.length-1 && aux==2){
				System.out.print("numeros nao se repetem");
			}
			aux=1;
		}
		tempoFinal = System.currentTimeMillis();
		System.out.println("\nTempo: "+ (tempoFinal - tempoInicial)+"/ms");
	}
	
	public static long brutaoVerificaRepeticao(){
		tempoInicial = System.currentTimeMillis();
		long repeteco, value=0;
		int quant,verifica=0;
		for(int i = 0; i < vet.length; i++){
			
			repeteco=vet[i];
			quant=0;
			for(int j = 0; j < vet.length; j++){
				
				if(repeteco==vet[j]){
					quant++;
					if(quant > verifica){
						verifica = quant;
						value=vet[j];
					}
				}
				
			}
		}
		tempoFinal = System.currentTimeMillis();
		System.out.println("\nO número que mais se repete é: "+ value + " e se repete "+ verifica + " vezes");
		System.out.println("\nTempo: "+ (tempoFinal - tempoInicial)+"/ms");
		return value;
	}
	
	public static void brutaoAchaNum(){
		
		int hasNum = 3;
		tempoInicial = System.currentTimeMillis();
		for(int i=0; i < vet.length; i++){
			
			if(vet[i] == hasNum){
				System.out.println("\nO número " + hasNum + " existe no vetor e se encontra na posicao "+ i );
				break;
			}
			if(i==vet.length-1 && vet[i] != hasNum){
				System.out.println("\nO numero não se encontra no vetor");
			}
		}
		tempoFinal = System.currentTimeMillis();
		System.out.println("\nTempo: "+ (tempoFinal - tempoInicial)+"/ms");
	}
	
	
	public static void main(String[] args) {
		
	menu();
		 
		
	}

	public static void menu(){
		
		quickSearch qS = new quickSearch();
		/*int i=0;
		 randomize();
		 brutaoVerificaMaisDeUm();
		 vet = QuickSort.quickSort(vet, ini, fim);
		 qS.quickFindAlg();*/
		 
		/* randomize();
		 provaReal=brutaoVerificaRepeticao();
		 vet = QuickSort.quickSort(vet, ini, fim);
		 provaReal2 = qS.quickRepete();
		 if(provaReal != provaReal2){
		    	System.out.println("Note que houve valores diferentes mas "+ provaReal+" se repete na mesma proporção que "+provaReal2);
		    }*/
		 
		 randomize();
		 brutaoAchaNum();
		 vet = QuickSort.quickSort(vet, ini, fim);
		 qS.quickChave();
	}
}
