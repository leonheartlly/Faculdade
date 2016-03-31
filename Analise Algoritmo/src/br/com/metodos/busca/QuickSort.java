package br.com.metodos.busca;

import br.com.analiseAlgoritmo.forcaBruta.existeVar;

public class QuickSort {
	public static long quickT;
	public static int partition(long arr[], int left, int right)
	{
		//seta o i = começo, j = fim;
	      int i = left, j = right;
	      long tmp;
	      //seta o pivot com o valor da posição do meio do vetor
	      long pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	    	  //roda o array de inicio até o meio
	            while (arr[i] < pivot)
	                  i++;
	            //roda o array do fim até o meio
	            while (arr[j] > pivot)
	                  j--;
	            //este ponto é efetuado a logica de analisar se todos os itens de um lado do pivo é menor que ele
	            //e do outro se é maior que o pivo
	            
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	public static long[] quickSort(long arr[], int left, int right) {
		long tempoInicial = System.currentTimeMillis();
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	      
	      /*for(int i=0;i <= right;i++){
			  System.out.print(arr[i]);
			   }*/
	      long tempoFinal = System.currentTimeMillis();
	      
	      quickT = tempoFinal - tempoInicial;
	      return arr;
	}
}
