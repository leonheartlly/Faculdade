package minimizador_afd;

import java.util.HashMap;
import java.util.Map;

public class AFD {

	public String[] E;
	public String[] A;
	public String I;
	public String[] F;
	public String[][] S;
	
	
	Map<String, Integer> example = new HashMap<String, Integer>();	
	Map<String, Integer> example2 = new HashMap<String, Integer>();
	

	public AFD(String[] E, String[] A, String I, String[] F, String[][] S) {
		this.E = E;
		this.A = A;
		this.I = I;
		this.F = F;
		this.S = S;
		mapeamento();
	}
	
	public void mapeamento (){
	
		for(int j =0; j<E.length; j++){
			example.put(E[j], j);
			
		}
		for(int j =0; j<A.length; j++){
			example2.put(A[j], j);
			
		}
	}
	
	public Boolean leitura (String [] palavra){
		String estado = I;
		for(int j =0; j<palavra.length; j++){
                    estado = S[example.get(estado)] [example2.get(palavra[j])];
		}
		
		Boolean aceita = false;
		for(String estado_f:F){
                    aceita = aceita || (estado_f.equals(estado));
		}
		
		return aceita;
	}
        
        public boolean contem_em_F(String estado){
            for(String el : F)
                if(el.equals(estado)) return true;
            return false;
        }
        
        public void imprimir(){
            System.out.print("Estados: { ");
            for(String estado : this.E)
                System.out.print("["+estado+"] ");
            System.out.println("}");
            
            System.out.print("Alfabeto: { ");
            for(String simbol : this.A)
                System.out.print(simbol+" ");
            System.out.println("}");
            
            System.out.println("Estado Inicial: "+this.I);
            
            System.out.print("Estados Finais: { ");
            for(String estado : this.F)
                System.out.print("["+estado+"] ");
            System.out.println("}");
            
            System.out.println("Transicoes: ");
            for(String simbol : this.A)
                System.out.print("\t"+simbol);
            System.out.println();
            for(int i=0; i<this.S.length; i++){
                System.out.print(this.E[i]+"\t");
                for(String estado : this.S[i]){
                    System.out.print(estado+"\t");
                }
                System.out.println();
            }
        }
}
