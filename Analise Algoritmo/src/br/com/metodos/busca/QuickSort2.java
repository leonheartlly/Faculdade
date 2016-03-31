package br.com.metodos.busca;

public class QuickSort2 {
	
	 public static void quick_sort(int []v,int ini, int fim) {
		   int meio;
		   if (ini < fim) {
		     meio = partition(v, ini, fim);
		     quick_sort(v, ini, meio);
		     quick_sort(v, meio + 1, fim);
		   }
		   for(int i=0;i < fim;i++){
		  System.out.println(v[i]);
		   }
		 }
		 
		 public static int partition(int []v, int ini, int fim) {
		   int pivo, topo, i;
		   pivo = v[ini];
		   topo = ini;
		 
		   for (i = ini + 1; i <= fim; i++) {
		     if (v[i] < pivo) {
		       v[topo] = v[i];
		       v[i] = v[topo + 1];
		       topo++;
		     }
		   }
		   v[topo] = pivo;
		   return topo;
		 }

}
