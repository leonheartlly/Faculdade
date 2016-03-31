package br.com.metodos.busca;

import java.util.Scanner;
import java.util.StringTokenizer;
  
class Main
{
    public static void main(String[] args) 
    {
        Scanner tec = new Scanner(System.in);
        int cont;
        do{
        cont = 2;
        String frase = tec.nextLine();
        frase = frase.toLowerCase();
        char letra = frase.charAt(0);
        boolean teste = false;
        StringTokenizer toc = new StringTokenizer(frase);
        char nome = '*';
        if(frase.charAt(0) != nome){
           while(toc.hasMoreTokens()){
            String tok = toc.nextToken();
            char let = tok.charAt(0);
             if(let == letra)
                teste = true;
               else{ teste = false;
                     break;
                  }
        }
          
            if(teste == true)
              System.out.println("Y");
               else
                 System.out.println("N");
        }else cont = 1;
  
    }while(cont != 1);
    }
      
}