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

public class IntFromBaseB {

    // gets the real int value for each char (or integer) from string input
    public static int val(char c){
        if(c >= '0' && c <= '9')
            return (int)c - '0';
        else
            return (int)c - 'a' + 10;
    }

    // recursive function that does the convertion
    public static int integerFromB(String s, int b, int result, int i) {
        result += val(s.charAt(i))*(int)Math.pow(b, s.length()-1-i);
        i++;
        if(i==s.length()) return result; // base case
        return integerFromB(s, b, result, i);
    }


    public static void main(String[] args) {
        int b = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            int result = 0; // aux variable to integerFromB()
            int i=0; // aux variable for the powers of 10 in integerFromB()
            StdOut.println(integerFromB(s, b, result, i));
        }
    }


}