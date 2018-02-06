/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 2.1.5 (Voting Machines)
 *  Data: 14/05/2017
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class VotingMachinesDeluxe {

	// function that simulates each voter's vote
	public static int voting(double f, int res){ 
		// 0 = A && 1 = B;
		double r = Math.random();
		if(r <= f && res == 0) res = 1;
		else if(r <= f && res == 1) res = 0;

		return res; 
	}

	// function that simulates the election T times and returns how many go wrong
	public static int election(double f, double t, int areal, int winner, int n){
		
		int wa = 0, counter = 0;

		while(counter <= t){

			int votesa = 0;
			int votesb = 0;
			int simuwinner = 0; // simulation winner

			// simulate votes that should go to candidate A
			for(int i=1; i<=areal; i++){ 
				if(voting(f, 0) == 0) votesa++;
				else votesb++;
			}

			// simulate votes that should go to candidate B
			for(int i=1; i <= (n-areal); i++){ 
				if(voting(f,1) == 0) votesa++;
				else votesb++;
			}
			
			if(votesa > votesb) simuwinner = 0;
			else simuwinner = 1;

			if(simuwinner != winner) wa++;

			counter++;
		}

		return wa;
	}

	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		double a = Double.parseDouble(args[1]);
		double b = Math.abs(1 - a);
		double t = Double.parseDouble(args[2]);

		// number of votes for candidate A
		int areal = (int) Math.ceil(n*a); 

		// see who is the actual winner
		int winner = 0;
		if(b>a) winner = 1;

		// initial state for binary search
		double ini = 0.0, fim = 0.55;
		double f = 0.0;

		// check if we found the answer
		boolean found = false;

		// binary search
		while(found == false){
			
			f = (ini + fim)/2;

			int wa = election(f, t, areal, winner, n);

			// checks precision
			if(Math.abs(wa/t - 0.03) <= 1e-4 && ini-f < 1e-3 && fim - f < 1e-3){ 
				found = true;
				break;
			}

			if(wa/t > 0.03) fim = f;
			if(wa/t < 0.03) ini = f;

		}

		StdOut.println(f);
	}
}