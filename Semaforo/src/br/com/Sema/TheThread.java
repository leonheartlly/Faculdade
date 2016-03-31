package br.com.Sema;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class TheThread {

	public static List<Integer> numeros;

	public TheThread() {
		this.numeros = new ArrayList<Integer>();
	}
	

	public static void main(String[] args) throws InterruptedException {
		Semaphore n  =  new Semaphore(1);
		
		Tratadores tratador1 = new Tratadores("Tratador1"), tratador2 = new Tratadores(
				"Tratador2");
		Observador obs = new Observador();
		obs.start();
		tratador1.start();
		tratador2.start();
		while (true) {
			obs.run();
			
			n.acquire();
			
			
			if (obs.getNum() <= 40) {
				
				
				
				tratador1.run();
				
				
			} 
			if (obs.getNum() > 50) {
				
				
				
				tratador2.run();
				
				
				
			}
			n.release();
			Thread.sleep(1000);
		}
	}
}
