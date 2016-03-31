package br.com.Desafio;

import java.util.Random;

/**
 * Given is an ordered deck of n cards numbered 1 to n with card 1 at the top
 * and card n at the bottom. The following operation is performed as long as
 * there are at least two cards in the deck: Throw away the top card and move
 * the card that is now on the top of the deck to the bottom of the deck.
 * 
 * Your task is to find the last, remaining card.
 * 
 * Each line of input (except the last) contains a positive number n ≤ 500000.
 * The last line contains 0 and this line should not be processed. For each
 * number from input produce one line of output giving the last remaining card.
 * Input will not contain more than 500000 lines.
 * 
 * Sample input
 * 
 * 7 19 10 6 0 
 * 
 * Output for sample input
 * 
 * 6 6 4 4
 * 
 * @author Lucas
 * 
 */

public class Cartas {
	
	long []vet =  new long[6];
	
	public void rand(){
		Random rand = new Random();
		
		for(int i = 1; i < 6; i++){
			vet[i]=rand.nextInt(6);
		}
	}
	public void encontra(){
		
		for(int i = vet.length; i > 0; i--){
			
			System.out.println(vet[i-1]);
			if(i==1){
				System.out.println(vet[i]);
				break;
			}
			
		}
	}

	public static void main(String[] args) {
		
		
	
	}

}
