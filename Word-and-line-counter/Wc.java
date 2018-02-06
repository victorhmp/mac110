/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.5.1 (Word and line count)
 *  Data: 30/04/2017
 *
 *  Baseado em WordCount.java / CharCount.java / LineCount.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Wc{
	public static void main(String[] args) {
		int w = 0;
		int l = 0;
		int c = 0;
		int i = 0;
		int aux = 0;
   
        while (!StdIn.isEmpty()) {
            String word = StdIn.readAll();
            while (i < word.length()) {
            	char n = word.charAt(i);
	    		if (n == '\n') l++;
	    		if(!Character.isWhitespace(n)) aux++;
	    		if(Character.isWhitespace(n) && aux>0){
	    			w++;
	    			aux = 0;
	    		}
	    		c++;
	    		i++;
        	}
        }
		StdOut.println(l + " " + w + " " + c);
	}
}