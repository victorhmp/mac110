/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 2.3.33 (Interleaving two strings)
 *  Data: 30/05/2017
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

public class Shuffle {
  
    // generate and print interleavings recursively 
    private static void shuf(String s, String t, char[] inter, int m, int n, int i, int i_s, int i_t) {
        
        // base case: no more characters to add from s or t
        if(m==0 && n==0) 
            System.out.println(inter);

        // if there are still characters from s to add
        if(m!=0){
            inter[i] = s.charAt(i_s);
            shuf(s, t, inter, m-1, n, i+1, i_s+1, i_t);
        }

        // if there are still characters from t to add
        if(n!=0){
            inter[i] = t.charAt(i_t);
            shuf(s, t, inter, m, n-1, i+1, i_s, i_t+1);
        }

    }

	public static void main(String[] args) {
        // receive inicial strings
        String i1 = args[0];
        String i2 = args[1];
        
        char[] result = new char[i1.length() + i2.length()];

        shuf(i1, i2, result, i1.length(), i2.length(), 0, 0, 0); 

	}
}