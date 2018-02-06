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

public class ConnFour{
	public static void main(String[] args) {

		String in = args[0];

		int seq = 1; //instant sequence
		int k = 0;
		int resp = 0; //answer
		char ori = 'a'; // orientation
		char chave = 'a'; // char thats being repeated
		int l = 0; //line coordinate for the answer
		int c = 0; //column cordinate for the awnswer

		int n = (int)Math.sqrt(in.length()); //side of the n x n board

		char board[][];
		board = new char[n][n];

		for(int i=0;i<n;i++){ //creating matrix board
			for (int j=0; j<n; j++){
				board[i][j] = in.charAt(k);
				k++;
			}
		}

		for(int i=0;i<n;i++){ //printing out the board
		    for(int j=0;j<n;j++){
		   		System.out.printf("%c ", board[i][j]);
		   	}
		   	if(i!=n)System.out.printf("\n");
		}

		for(int i=0;i<n;i++){ //checking horizontal sequences
			seq = 1;
			for (int j=0; j<n-1; j++){
				if(board[i][j] == board[i][j+1]) {
					seq++;
				}
				if(seq>resp){
					resp = seq;
					ori = 'h';
					chave = board[i][j+1];
					l = i;
					c = j+2-resp;
				}
				if(board[i][j] != board[i][j+1]){
					seq=1;
				}
			}

		}

		for(int j=0;j<n;j++){ //checking vertical sequences
			seq = 1;
			for (int i=1; i<n; i++){
				if(board[i][j] == board[i-1][j]){
					seq++;
				}
				if(seq>resp){
					resp = seq;
					ori = 'v';
					chave = board[i-1][j];
					c = j;
					l = i+1-resp;
				}
				if(board[i][j] != board[i-1][j]){
					seq = 1;
				}
			}
		}


		System.out.printf("%d / (%d, %d) [%c / %c]\n", resp, l, c, chave, ori);

	}
}