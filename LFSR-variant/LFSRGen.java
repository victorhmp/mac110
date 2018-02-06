/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.4.6 (Linear feedback shift register; variante)
 *  Data: 23/04/2017
 *
 *  Baseado em LFSR.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class LFSRGen{
	public static void main(String[] args) {

		String s = args[0]; //receives seed as a string
		int tap = Integer.parseInt(args[1]); //tap position
		int t = Integer.parseInt(args[2]); //number of steps

		int seed[];

		int n = s.length();
		seed = new int[n+10];

		for(int i=0;i<n;i++){
			if(s.charAt(i) == '1') seed[i] = 1;
			else seed[i] = 0;
		}

		for(int k=0; k<t; k++){
			int next = (seed[0] ^ seed[n-1-tap]);

			for(int i=0;i<n-1;i++)
				seed[i] = seed[i+1];

			seed[n-1] = next;

			System.out.print(next);
		}

		System.out.println();
	}
}