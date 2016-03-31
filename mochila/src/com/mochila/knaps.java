package com.mochila;

public class knaps {
	



		public static int max(int a, int b) {
			return a > b ? a : b;
		}

		public static  void Knapsack(int items,int weight[],int value[],int maxWeight){
			int dp[] []= new int[items+1][maxWeight+1];
			int i, w;
			//roda até o peso+1 guardando 0 na posição
	        for(i=0;i<=maxWeight;i++){
	                dp[0][i]=0;
	        }
	        //roda até itens +1 guardando 0 na posição
	        for(i=0;i<=items;i++){
	                dp[i][0]=0;
	        }
	        
	        for(i=1;i<=items;i++){
	                for(w=0;w<=maxWeight;w++){
	                        dp[i][w] = dp[i-1][w]; 
	                        if(w-weight[i] >=0){
	                               
	                                dp[i][w] = max(dp[i][w], dp[i-1][w-weight[i]]+value[i]);
	                        }
	                }
	        }
	       System.out.println("\nA matriz : \n");
			for(i=0;i<=items;i++){
				for(w=0;w<=maxWeight;w++) System.out.print(" "+dp[i][w]);
			System.out.print("\n");
			}
	   System.out.println("\nValor maximo atribuido na mochila: "+ dp[items][maxWeight]);
	       System.out.println("\nOs itens selecionados sao: ");
			i=items;w=maxWeight;
			while(i>0 && w>0){
				if(dp[i][w]!=dp[i-1][w]){
					System.out.println(i);
					dp[i][w]=dp[i-1][w-weight[i]];
					w=w-weight[i];
					 i=i-1;
				}
				else{
					dp[i][w]=dp[i-1][w];
					i=i-1;
				}
			}
	}

		public static void main(String[] args) {
			  int items, maxWeight, i;
			  maxWeight= 10;
			  items=2;
			  
			  int weight []= {4, 2}; 
			  int value []= {6, 4};
		      
		        Knapsack(items,weight,value,maxWeight);
		     

		}
	}

