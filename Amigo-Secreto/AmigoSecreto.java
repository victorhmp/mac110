/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 2 (Amigo Secreto)
 *  Data: 16/04/2017
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 *
 ******************************************************************************/

public class AmigoSecreto{
    public static void main(String[] args){
		
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		int n=2;

		int friends[];
		boolean given[];
		int f[];

		while(n<=N){
			friends = new int[n+10];
			int resp = 0;
			int c = 1;


			while(c <= T){
				int t = 0;
				given = new boolean[n+10];
				for(int i=0;i<=n;i++) given[i] = false;
				int give = 0;
				int counter = 0;
				f = new int[n+10];
				for(int i=1; i<=n; i++) f[i] = 0;

				//creating array filled with random integers from 0 to n without duplicates
				for(int i=0;i<n;i++){
	    			friends[i] = (int)(Math.random() * n);
	    			while(f[friends[i]] != 0) friends[i] = (int)(Math.random() * n);
	    			if(f[friends[i]] == 0)  f[friends[i]]++;
				}
    
				while(counter<n-1){
					if(given[t] != true){
						give = friends[t];
						given[t] = true;
						t = give;
						counter++;
					}
					if(given[t] == true)
						t = (int)(Math.random()*n);
				}
				c++;
				if(give == 0) resp++;
			}
			double r = ((double)resp/T)*100;
			System.out.printf("%d %f \n", n, r);
			n++;
		}
    }
}
