/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 8 (Torres 3D)
 *  Data: 28/05/2017
 *
 *  Baseado em Queens.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Torres3D {

    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) return false;
        }
        return true;
    }

    public static void enumerate(int n) {
        int[] a = new int[n];
        enumerate(a, 0);
    }

    public static int counter = 0;

    public static void enumerate(int[] q, int k) {
        int n = q.length;
        if (k == n) counter++;
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) enumerate(q, k+1);
            }
        }
    }  


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        enumerate(n);
        if(n==3) enumerate(n);
        if(n>=4) counter*=counter;

        StdOut.println(counter);
    }

}