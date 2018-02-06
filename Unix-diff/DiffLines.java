/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Variante do Web Exercise 2.3.51 (Unix diff)
 *  Data: 13/06/2017
 *
 *  Baseado em: Diff.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class DiffLines{
	public static void main(String[] args) {

        // read in lines and split them
        String l1 = StdIn.readLine();
        String l2 = StdIn.readLine();
        String[] x = l1.split("\\s+");
        String[] y = l2.split("\\s+");

        // strings that should be printed
        String f1 = "";
        String f2 = "";

        // number of words on each line
        int m = x.length;
        int n = y.length;

        // opt[i][j] = length of LCS of x[i..m] and y[j..n]
        int[][] opt = new int[m+1][n+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (x[i].equals(y[j]))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and construct f1 and f2
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (x[i].equals(y[j])) {
                
                f1+=x[i]+" ";
                i++;

                f2+=y[j]+" ";
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) f1+="*"+x[i++]+"* ";
            else                                 f2+="*"+y[j++]+"* ";
        }

        // dump out one remainder of one string if the other is exhausted
        while (i < m || j < n) {
            if      (i == m) f2+="*"+y[j++]+"* ";
            else if (j == n) f1+="*"+x[i++]+"* ";
        }

        StdOut.println("First line:");
        StdOut.println(f1);

        StdOut.println("Second line:");
        StdOut.println(f2);
    }
}