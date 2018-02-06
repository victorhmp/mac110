/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Variante do Creative Ex. 2.3.17 (Permutations)
 *  Data: 14/05/2017
 *
 *  Baseado em Permutations.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Arrangements {

 	// print n! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    
    private static void perm1(String prefix, String s) {
    	boolean[] l = new boolean[256]; // bool array with the size of ASCII table
    									// each array index is the ASCII code of a char
        int n = s.length();
        if (n == 0) // base case
        	StdOut.println(prefix);
        else {
            for (int i = 0; i < n; i++){
            	if(l[s.charAt(i)] == false){ // prevents duplicates
               		perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
               		l[s.charAt(i)] = true;
            	}
            }
        }

    }

	public static void main(String[] args) {

        String elements = args[0]; // receive inicial string
        perm1(elements); // generate permutations and print them

	}
}