package com.hacks4eva.broker;

import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Broker {

	private String senha;
	private char[] caracteres;
	
	public void Broker(){}
	
	public void Senha(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a senha a ser roubada: ");
		
			
			this.senha = scan.next();

		for(int i=0;i<senha.length();i++){
			
			caracteres=this.senha.toCharArray();

		}
		
		
	
		
	}
	public String quebraSigilo(){
		Broker b = new Broker();
		String senhaHackeada = "";
		
		for(int i = 0;i<senha.length();i++){
			
			for(char j=0;j<255;j++){
				
			if(j==caracteres[i]){
				senhaHackeada = senhaHackeada+j;
			}
			}
		}
		return senhaHackeada;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Broker br = new Broker();
		br.Senha();
		String suaSenha=br.quebraSigilo();
		JOptionPane.showMessageDialog(null,"Sua senha foi Hackeada!\nA senha é: "+suaSenha);
		
		
	}

}
