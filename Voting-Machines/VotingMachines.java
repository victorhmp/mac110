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

public class VotingMachines {
	
	public static int voting(double f, int res){
		// 0 = A && 1 = B;
		double r = Math.random();
		if(r <= f && res == 0) res = 1;
		else if(r <= f && res == 1) res = 0;

		return res; 
	}

	public static void main(String[] args) {
		// dados N, a, f, calcular a probabilidade p(N,a,f) de B ganhar as eleicoes
		// ele pode ganhar justamente ou devido aos erros das urnas
		int n = Integer.parseInt(args[0]);

		double a = Double.parseDouble(args[1]);
		double b = Math.abs(1-a);
		int areal = (int) Math.ceil(n*a); // number of votes for candidate A

		// see who is the actual winner
		int winner = 0;
		if(b>a) winner = 1;

		int wa = 0; // number of elections that go wrong

		double f = Double.parseDouble(args[2]);
		double t = Double.parseDouble(args[3]);
		
		// loop counter
		int counter = 1;

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
		
		StdOut.println("Wrong results/trials: " + wa + "/" + (int)t);
		if(wa/t > 0.03) StdOut.println("These values are not acceptable");
		else StdOut.println("These values are acceptable");
	}
}