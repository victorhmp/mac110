/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Variante do Web Ex. 2.1.5 (Voting Machines)
 *  Data: 22/05/2017
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class VotingMachinesGraph {
	
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
		double areal = n*a;

		double f = Double.parseDouble(args[2]);
		double t = Double.parseDouble(args[3]);
		
		int t_idx = (int) t;
		int[] freq = new int[t_idx+1];

		double[] x_a = new double[t_idx];
		
		// loop counter
		int counter = 0;

		while(counter < t){
			int votesa = 0;
			int votesb = 0;

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

			x_a[counter] = votesa;
			freq[votesa]++;

			counter++;
		}

		double mean_xa = StdStats.mean(x_a);
		double stddev_xa = StdStats.stddev(x_a);

		StdOut.println("M = "+ mean_xa);
		StdOut.println("D = "+ stddev_xa);
		if(n<=100) StdDraw.setYscale(0, 0.18);
		if(n>100 && n<500) StdDraw.setYscale(0, 0.11);
		if(n>=500) StdDraw.setYscale(0, 0.05);
		//StdDraw.setYscale(0, 0.15);

		// plot normalized values
        double[] normalized = new double[n+1];
        for (int i = 0; i <= n; i++) {
            normalized[i] =  (double) freq[i] / t_idx;
        }
        StdStats.plotBars(normalized);

        // plot Gaussian approximation
        double[] phi  = new double[n+1];
        for (int i = 0; i <= n; i++) {
            phi[i] = Gaussian.pdf(i, mean_xa, stddev_xa);
        }
		
		StdDraw.setPenColor(StdDraw.BLUE);
		StdStats.plotLines(phi);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(n/2, 0.0, n/2, 0.2);

		StdDraw.save("histogram-"+n+"-"+a+"-"+f+"-"+t_idx+".jpg");
		
	}

}