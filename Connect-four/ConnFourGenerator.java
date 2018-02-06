/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.4.10 (Connect four)
 *  Data: 23/04/2017
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

public class ConnFourGenerator{
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]); //side of the n x n board
		int com = Integer.parseInt(args[1]); //command
		char board[][]; //bidimensional array to store the board

		board = new char[n+1][n+1];

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n; j++){
				double aux = Math.random(); //random choice of characters
				if(aux <= (1.0/3.0)) board[i][j] = '*';
				if(aux > (1.0/3.0) && aux <= (2.0/3.0)) board[i][j] = 'O';
				if(aux > (2.0/3.0)) board[i][j] = 'X';
			}
		}
		if(com==1){ //printing everything in a single line
		    for(int i=1;i<=n;i++){
		    	for(int j=1;j<=n;j++){
		    		System.out.printf("%c", board[i][j]);
		    	}
		    }
		}
		if(com==0){ //printing line-by-line
			for(int i=1;i<=n;i++){
		    	for(int j=1;j<=n;j++){
		    		System.out.printf("%c ", board[i][j]);
		    	}
		    	if(i!=n)System.out.printf("\n");
		    }
		}
		System.out.println();
	}
}