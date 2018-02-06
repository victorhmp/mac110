/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 10 (Partições de inteiros)
 *  Data: 06/06/2017
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Partitions {

      public static long[][] memo = new long[1123][1123];

      public static long p(int n, int m){
        if(m==1 || n==0) return 1;
        if(m>n) return p(n, n);
        if(memo[n][m]!=0) return memo[n][m];

        memo[n][m] = p(n, m-1) + p(n-m, m);
        return memo[n][m];
      }

      public static void main(String[] args) {
          int n = Integer.parseInt(args[0]);
          int m = n;

          System.out.println(p(n, m));
      }
}
