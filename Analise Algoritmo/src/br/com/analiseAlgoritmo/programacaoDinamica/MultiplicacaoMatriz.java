package br.com.analiseAlgoritmo.programacaoDinamica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicacaoMatriz {
	public static void main(String [ ] args)throws IOException {
		
		int n;
		int maxn = 4;
		
		int d[] = new int [maxn + 1];
		int m[ ] [ ] = new int [maxn] [maxn] ;
		
		BufferedReader in = new BufferedReader (
		new InputStreamReader (System.in ));
		
		System.out.println( "Numero de matrizes n: " );
		n = Integer.parseInt( in.readLine());
		
		System.out.println( "Dimensoes das matrizes: " );
		for ( int i = 0; i <= n; i ++) {
		System.out.print ( " d[ "+i+" ] = " );
		d[ i ] = Integer.parseInt( in.readLine ());
		}
		
		for ( int i = 0; i < n; i ++) m[ i ] [ i ] = 0;
		
		//enquanto h menor que quantidade de matrizes
		for ( int h = 1; h < n; h++) {
			//enquanto i <= quant matriz - h
		for ( int i = 1; i <= n - h; i ++) {
			
		int j = i + h;
		
		m[ i -1][j -1] = Integer .MAX_VALUE;
		
		for ( int k = i ; k < j ; k++) {
			
		int temp = m[ i -1][k-1] + m[k] [ j -1] + d[ i -1] * d[k] * d[ j ] ;
		//temp = formula min {m [i][k] + m [k+1][j] + d[i-1]*d[k]*d[j]
		
		if (temp < m[ i -1][j -1]) m[ i -1][j -1] = temp;
		}
		System.out.print ( " m[ " + i+" ] [ "+j+" ]= "+ m[ i -1][j -1]);
		}
		
		System.out.println ();
		}
		
		}
		

}
