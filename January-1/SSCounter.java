/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.3.26 (January 1)
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

public class SSCounter{
	public static void main(String [] args){
		int D = Integer.parseInt(args[0]); //dia D do mes M
		int M = Integer.parseInt(args[1]);
		boolean leapYear; 

		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		double y = 1;
		int s = 1, sun = 0, sat = 0;

		for(y = 1; y<=400; y++){
			if (y % 100 == 0) leapYear = false;
			else leapYear = (y % 4 == 0 && y>=4);
			
			for(int m = 1; m<=12; m++){
				if(leapYear==false){
					days[2] = 28;
					for(int d=1; d<=days[m]; d++){
						if(d == D && m==M && s == 6) sat++;
						if(d == D && m==M && s == 7) sun++;
						if(s==7) s = 0;
						s++;
					}
				}
				if(leapYear==true){
					days[2] = 29;
					for(int d=1; d<=days[m]; d++){
						if(d == D && m==M && s == 6) sat++;
						if(d == D && m==M && s == 7) sun++;
						if(s==7) s = 0;
						s++;
					}
				}

			}
		}

		System.out.println("Saturday: " + sat + "; " + "Sunday: " + sun);

	}
}