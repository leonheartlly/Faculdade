package minimizador_afd;

public class Instancias {
    public static AFD get_maquina(int m){
        AFD maq = null;
        switch(m){
            case 0 : maq = maquina1(); break;
        }
        return maq;
    }
    
    private static AFD maquina1(){
        String[] E = {"0", "1", "2", "3", "4", "5"};
	String[] A = {"0", "1"};
	String I = "0";
	String[] F = {"0"};
	String[][] S = {{"0", "1"},
                        {"2", "3"},
                        {"4", "5"},
                        {"0", "1"},
                        {"2", "3"},
                        {"4", "5"}};
        return new AFD(E, A, I, F, S);
    }
}
