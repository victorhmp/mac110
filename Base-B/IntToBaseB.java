/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex.6 (Base B)
 *  Data: 21/05/2017
 *
 *  Baseado em Binary.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class IntToBaseB {

    // char array with every number and letter of the alphabet
    private static char symbols[] = new char[] {
        '0','1','2','3','4','5','6','7','8','9',
        'a','b','c','d','e','f','g','h','i','j',
        'k','l','m','n','o','p','q','r','s','t',
        'u', 'v', 'x', 'w', 'y', 'z' 
    };

    //recursive function that does the convertion
    public static String baseB(int n, int b) {
        if (n==1) return "1"; // base case
        if(n==0) return ""; // base case
        return baseB(n/b, b) + symbols[n%b]; // using n%b as index makes it easier to use letters
    }


    public static void main(String[] args) {
        int b = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()){
            int n = StdIn.readInt();
            StdOut.println(baseB(n, b));
        }
    }

}