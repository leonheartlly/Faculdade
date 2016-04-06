package br.com.lfa.afd;

import java.util.Scanner;


public class AFD {
	
	public static void main(String [] args){
		AFD afd = new AFD();
		afd.regra();
		
	}
	
	private void regra() {
		Scanner scan = new Scanner(System.in);
		String into = scan.next();
		
		Estado q = new Estado();
		String E = "",testedWord = "";
		String []Q = {q.getQ0(),q.getQ1(),q.getQ2(),q.getQf()};
		int pointsTo = 0, i = 0;
		String []testedLetter = into.split("");
		
			while(pointsTo!=3){
				if(pointsTo == 0 && testedLetter[i].equals("a")){
					pointsTo+=1;
					i++;
					E += "Q0 , Q1 ,";
					testedWord+=Q[pointsTo];
				}
				if(pointsTo == 1 && testedLetter[i].equals("a")){
					pointsTo=2;
					i++;
					E+="Q2 ,";
					testedWord+=Q[pointsTo];
				}
				if(pointsTo == 2 && testedLetter[i].equals("a")){
					pointsTo=1;
					testedWord+=Q[pointsTo];
					E+= "Q1 ,";
					i++;
				}
				if(pointsTo == 2 && testedLetter[i].equals("b")){
					pointsTo=3;
					i++;
					E+="Q3";
					testedWord+=Q[pointsTo];
					break;
					
				}
				if(testedLetter[0].equals("b"))
					i = testedLetter.length-1;
				if(testedLetter.length-1 == i && pointsTo!=3){
					testedWord = "Não pertence a linguagem";
					break;
				}
				
			}
			if(!testedWord.equals(into))
			System.out.println("PALAVRA: "+testedWord);
			else
			System.out.println("PALAVRA: "+testedWord+"\nESTADOS: "+E +"\nPERTENCE A LINGUAGEM");
			scan.close();
	}

}
