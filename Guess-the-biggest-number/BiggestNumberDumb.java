/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.2.9 (Guess the biggest number)
 *  Data: 07/04/2017
 *
 ******************************************************************************/

public class BiggestNumberDumb {

    public static void main(String[] args) {
	double a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int T = Integer.parseInt(args[2]);
	double p_menor = 0;
	double p_maior = 0;

	int bigger;
	if (a < b) bigger = 1;
	else bigger = 0;

	int right = 0;
	for (int i = 0; i < T; i++) {
	  	int pick = 0;
	  	if(Math.random()> .5){  p_menor = a/1000; pick = 0; p_maior = (1000-a)/1000;}
		else if(Math.random()<= .5){ p_menor = b/1000; pick = 1; p_maior = (1000-b)/1000;}

	    // p_menor = 500 + (500 * Math.abs( (b-a) ) ); chance de b ser a maior
	    
	    if (pick==1  && p_maior > p_menor) pick = 0 ;
	    else if(pick==0 && p_maior > p_menor) pick = 1;
	    
	    if (pick == bigger) right++;
	    else continue;
	}
	// Estatística
	double f = (double)right/T;
	System.out.println(right + " [" + f + "/" + (f - .5) + "]");
    }
}
