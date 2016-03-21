package minimizador_afd;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Minimizador {

	AFD M;
	List<int[]> LPO;
	int[][] m_eqv;
        
        List<List<int[]>> depend;

	public Minimizador(AFD M) {
		this.M = M;
		LPO = new ArrayList<int[]>();
		m_eqv = new int[M.E.length][M.E.length];
                
                depend = new ArrayList<List<int[]>>();
                for(int i=0; i<LPO.size(); i++){
                    depend.add(new ArrayList<int[]>());
                }
	}

        public AFD minimizar(){
            passo1();
            passo2();
            passo3();
            return gerar_afd_min();
        }
        
        public void imprimir(){
            System.out.println("Lista dos pares ordenados: ");
            for(int[] el : LPO)
                System.out.print("["+el[0]+","+el[1]+"] ");
            System.out.println();
            
            System.out.println("Lista de dependencias dos pares ordenados: ");
            for(String simbol : M.A)
                System.out.print("\t  "+simbol);
            System.out.println();
            for(int i=0; i<depend.size(); i++){
                System.out.print(M.E[LPO.get(i)[0]]+M.E[LPO.get(i)[1]]+":\t");
                for(int[] el : depend.get(i)){
                    System.out.print("["+el[0]+","+el[1]+"]\t");
                }
                System.out.println();
            }
            System.out.println();
            
            System.out.println("Matriz de Equivalencias: ");
            for(String estado : M.E)
                System.out.print("\t"+estado);
            System.out.println();
            for(int i=0; i<m_eqv.length; i++){
                System.out.print(M.E[i]+"\t");
                for(int valor : m_eqv[i]){
                    System.out.print(valor+"\t");
                }
                System.out.println();
            }
        }
        
	public void passo1() {
		for (int i = 0; i < M.E.length - 1; i++) {
                    for (int j = i + 1; j < M.E.length; j++) {
			LPO.add(new int [] {M.example.get(M.E[i]),M.example.get(M.E[j])});
                    }
		}
                List<int[]> list = new ArrayList<int[]>();
		for(int t=0; t<M.F.length; t++){
                    for(int k=0; k<LPO.size(); k++){
			if(M.contem_em_F(M.E[LPO.get(k)[0]]) && !M.contem_em_F(M.E[LPO.get(k)[1]])){
                           list.add(LPO.get(k));
                        }
                        if(!M.contem_em_F(M.E[LPO.get(k)[0]]) && M.contem_em_F(M.E[LPO.get(k)[1]])){
                           list.add(LPO.get(k));
                        }
                    }
		}
                
                while(list.size() > 0){
                    int index = -1;
                    for(int k=0; k<LPO.size(); k++){
                        if(list.get(0)[0] == LPO.get(k)[0] &&
                                list.get(0)[1] == LPO.get(k)[1]){
                            index = k;
                            break;
                        }
                    }
                    if(index != -1){
                        m_eqv[list.get(0)[0]][list.get(0)[1]] = 1;
                        m_eqv[list.get(0)[1]][list.get(0)[0]] = 1;
                        LPO.remove(index);
                        list.remove(0);
                    }
                }
	}
        
        public void passo2(){
            for(int[] el : LPO){
                List<int[]> list = new ArrayList<int[]>();
                for(String simbol : M.A){
                    list.add(new int[] {M.example.get(M.S[el[0]][M.example2.get(simbol)]),
                                            M.example.get(M.S[el[1]][M.example2.get(simbol)])});
                }
                depend.add(list);
            }
        }
        
        public void passo3(){
            for(int i=0; i<LPO.size(); i++){
                
                for(int j=0; j<LPO.size(); j++){
                    for(int[] dep : depend.get(j)){
                        if(m_eqv[dep[0]][dep[1]] == 1){
                            m_eqv[LPO.get(j)[0]][LPO.get(j)[1]] = 1;
                            m_eqv[LPO.get(j)[1]][LPO.get(j)[0]] = 1;
                            break;
                        }
                    }
                }
                
            }
        }
        
        public AFD gerar_afd_min(){
            List<int[]> estados_eqv = new ArrayList<int[]>();
            for(int i=0; i<M.E.length; i++) {
                estados_eqv.add(new int[] {i, -1});
            }
            
            for(int i=0; i<m_eqv.length; i++){
                for(int j=0; j<i; j++){
                    if(m_eqv[i][j] == 0){
                        estados_eqv.get(j)[1] = i;
                    }
                }
            }
            
            String[][] S;
            List<String> E = new ArrayList<String>();
            List<String> F = new ArrayList<String>();
            String I = "";
            
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<estados_eqv.size(); i++){
                int[] eqv = estados_eqv.get(i);
                String estado;
                if(!list.contains(i)){
                    if(eqv[1] != -1){
                        list.add(eqv[1]);
                        estado = Integer.toString(eqv[0])+Integer.toString(eqv[1]);
                        
                        E.add(estado);
                        if(M.E[eqv[0]].equals(M.I) || M.E[eqv[1]].equals(M.I))
                            I = estado;
                        if(M.contem_em_F(M.E[eqv[0]]))
                            F.add(estado);
                    } else {
                        estado = Integer.toString(eqv[0]);
                        
                        E.add(estado);
                        if(M.E[eqv[0]].equals(M.I))
                            I = estado;
                        if(M.contem_em_F(M.E[eqv[0]]))
                            F.add(estado);
                    }
                }
            }
            
            S = new String[E.size()][M.A.length];
            
            for(int i=0; i<E.size(); i++){
                for(int j=0; j<M.A.length; j++){
                    S[i][j] = get_estado_transicao(E, E.get(i), M.A[j]);
                }
            }
            
            String[] E2 = new String[E.size()];
            for(int i=0; i<E2.length; i++) E2[i] = E.get(i);
            
            String[] F2 = new String[F.size()];
            for(int i=0; i<F2.length; i++) F2[i] = F.get(i);
            
            return new AFD(E2, M.A, I, F2, S);
        }
        
        private String get_estado_transicao(List<String> E, String estado, String simbol){
            String estado_retorno = M.S[M.example.get(estado.substring(0, 1))][M.example2.get(simbol)];
            for(String est : E){
                if(est.contains(estado_retorno)) return est;
            }
            return null;
        }
}