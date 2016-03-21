package minimizador_afd;

public class Minimizador_AFD {
    
    public static void main(String[] args) {
        AFD afd = Instancias.get_maquina(0);
        afd.imprimir();
        System.out.println("=======================");
        
        Minimizador minimizador = new Minimizador(afd);
        AFD afd_min = minimizador.minimizar();
        
        minimizador.imprimir();
        System.out.println("=======================");
        afd_min.imprimir();
        System.out.println("=======================");
        
        String[] palavra = transforma_palavra("110");
        System.out.println("afd aceita 110? "+afd.leitura(palavra)+" | afd_min aceita 110? "+afd.leitura(palavra));
        
        palavra = transforma_palavra("00101111101110");
        System.out.println("afd aceita 00101111101110? "+afd.leitura(palavra)+" | afd_min aceita 00101111101110? "+afd.leitura(palavra));
        
        palavra = transforma_palavra("101101");
        System.out.println("afd aceita 101101? "+afd.leitura(palavra)+" | afd_min aceita 101101? "+afd.leitura(palavra));
        
        palavra = transforma_palavra("111110");
        System.out.println("afd aceita 111110? "+afd.leitura(palavra)+" | afd_min aceita 111110? "+afd.leitura(palavra));
        
    }
    
    public static String[] transforma_palavra(String palavra){
        String[] palavra_split = palavra.split("");
        String[] palavra_retorno = new String[palavra_split.length-1];
        for(int i=0; i<palavra_retorno.length; i++)
            palavra_retorno[i] = palavra_split[i+1];
        return palavra_retorno;
    }
}
