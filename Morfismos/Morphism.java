/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 7 (Morfismos)
 *  Data: 22/05/2017
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Morphism {
	
	// calculates f(u)
	public static String f_u(String s, String t, String u){
		String aux = "";
		for(int i=0;i<u.length();i++){
			if(u.charAt(i)=='0') aux+=s;
			if(u.charAt(i)=='1') aux+=t;
		}

		return aux;
	}

	// produces the desired sequence using recursion for f^n(u)
	public static String sequence(String s, String t, String u, int n, String u_base){
		if(n==0) return f_u(s, t, u_base);
		return f_u(s, t, sequence(s, t, f_u(s, t, u), n-1, u_base));
	}

	public static void main(String[] args) {
		String s = args[0];
		String t = args[1];
		int n = Integer.parseInt(args[2]);
		String u = StdIn.readString();

		for(int i=0;i<n;i++){
			if(i==0) StdOut.println(u); // base case
			StdOut.println(sequence(s, t, u, i, u)); // for each f^i(u) prints sequence
		}
	}
}