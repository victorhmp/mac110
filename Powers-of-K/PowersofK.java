/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.3.81 (Powers of K)
 *  Data: 05/04/2017
 *
 ******************************************************************************/


public class PowersofK{
	public static void main(String args[]){
		double power = Double.parseDouble(args[0]);
		double i = 0;
		double num = power;
		while(power<=Long.MAX_VALUE){
			power = Math.pow(num, i);
			i++;
			if(power<=Long.MAX_VALUE)System.out.print(i-1 + " " + power + "\n");
		}
	}
}