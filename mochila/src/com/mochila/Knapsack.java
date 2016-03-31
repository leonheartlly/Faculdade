package com.mochila;

import java.util.Random;

/**
 * 
 * 
 * Compilation: javac Knapsack.java Execution: java Knapsack N P W
 * 
 * Generates an instance of the 0/1 knapsack problem with N items, profits
 * between 0 and P-1, weights between 0 and W-1, and solves it in O(NW) using
 * dynamic programming.
 * 
 * % java Knapsack 6 1000 2000 item profit weight take 1 874 580 true 2 620 1616
 * false 3 345 1906 false 4 369 1942 false 5 360 50 true 6 470 294 true
 * 
 *************************************************************************/

public class Knapsack {
	
        private static final Random rnd = new Random();
        
        public static void main(String[] args) {
        		// Numero de itens
                int num = Integer.parseInt("2"); 
                // Lucro Maximo
                int valor = Integer.parseInt("4"); 
                // Peso Maximo
                int Weight = Integer.parseInt("4"); 
                
                int[] lucro = new int[num + 1];
                int[] peso = new int[num + 1];

                
                for (int n = 1; n <= num; n++) {
                		//gera um valor random em profit até o valor de P
                        lucro[n] = rnd.nextInt(valor);
                      //gera um valor random em profit até o valor de W
                        peso[n] = rnd.nextInt(Weight);
                }

                // opt[n][w] = max profit of packing items 1..n with weight limit w
                // sol[n][w] = does opt solution to pack items 1..n with weight limit w
                // include item n?
                //cria matriz com numero de itens +1 e numero maximo de peso +1
                int[][] opt = new int[num + 1][Weight + 1];
                boolean[][] sol = new boolean[num + 1][Weight + 1];

                for (int i = 1; i <= num; i++) {
                        for (int j = 1; j <= Weight; j++) {

                                // don't take item i
                        		//guarda em opt1 o valor da posição opt[i-1][j]
                                int option1 = opt[i - 1][j];

                                // take item i
                                int option2 = Integer.MIN_VALUE;
                                //analisa os menores pesos e guarda o valor do item correspondente na posição da matriz opt
                                if (peso[i] <= j)
                                        option2 = lucro[i] + opt[i - 1][j - peso[i]];

                                //math.max retorna o maior valor entre os numeros
                                //coloca o valor maior na posição opt[i][j]
                                opt[i][j] = Math.max(option1, option2);
                               //vetor booleano faz a comparação se o valor de opt2>opt1 retornando true caso seja
                                // e guardando na posição sol[i][j]
                                sol[i][j] = option2 > option1;
                                
                        }
                }

                // determine which items to take
                int total[];
                int aux=0;
                boolean[] take = new boolean[num + 1];
                for (int n = num, w = Weight; n > 0; n--) {
                        if (sol[n][w]) {
                        		
                                take[n] = true;
                                w = w - peso[n];
                                
                        } else {
                                take[n] = false;
                        }
                }

                // print results
                System.out.println("item" + "\t" + "lucro" + "\t" + "peso" + "\t"
                                + "pegar");
                for (int n = 1; n <= num; n++)
                        System.out.println(n + "\t" + lucro[n] + "\t" + peso[n] + "\t"
                                        + take[n]);
                System.out.println();
        }
}