package br.com.Sema;

public class Tratadores extends Thread {


	int aux;
	String nome;
	
	public Tratadores(String nome){
		this.nome=nome;
	}
	
	@Override
	public void run() {
		aux++;
		
		if(aux==10){
			System.out.println(nome+" notificado 10 vezes");
			aux=0;
			}
		}
	}


