/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 09 ( (a,b)-permutações) )
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


public class ABPerms {

    public static int perm(String done, String left, int[] decr, int[] cresc, int a, int b, int m){
        int n = left.length();
        if (n==0){
            if(m!=1)
                StdOut.println(done);
            return 1;
        }
        else{
            int s = 0;
            for(int i=0;i<n; i++){
                char l = left.charAt(i);
                int d_len = done.length();

                decr[d_len] = 0;
                cresc[d_len] = 0;
                int max_cresc = 0;
                int max_decr = 0;

                for(int j=0;j < d_len;j++){
                    if(l > done.charAt(j) && decr[d_len] < decr[j])
                        decr[d_len] = decr[j];
                    if(l < done.charAt(j) && cresc[d_len] < cresc[j])
                        cresc[d_len] = cresc[j];

                    if(max_decr < decr[j])
                        max_decr = decr[j];
                    if(max_cresc < cresc[j])
                        max_cresc = cresc[j];
                }

                decr[d_len]++;
                cresc[d_len]++;

                if(max_decr < decr[d_len])
                      max_decr = decr[d_len];
                if(max_cresc < cresc[d_len])
                    max_cresc = cresc[d_len];
                if(max_decr <= a && max_cresc <= b)
                    s = s + perm(done+l , left.substring(0, i) + left.substring(i+1,n), decr, cresc, a, b, m);
            }
            return s;
        }    
    }

    public static void main(String[] args) {
    	String alphastr = "abcdefghijklmnopqrstuvwxyz";

        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        int m = Integer.parseInt(args[3]);

        int[] decr = new int[n+10];
        int[] cresc = new int[n+10];

        String elements = alphastr.substring(0, n);

        int resp = perm("", elements, decr, cresc, a, b, m);

        if(m==2 || m==1) StdOut.println(resp);
    }

}