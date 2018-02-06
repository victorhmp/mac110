/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.3.25 (Friday the 13th)
 *  Data: 16/04/2017
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class WeekdayMonthday{
	public static void main(String [] args){
		int resp = 0, y=1, m=1, d=1, temp=1, s=1;
		boolean leapYear;
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int S = Integer.parseInt(args[0]); //day of the week (monday = 1; sunday = 7)
		int D = Integer.parseInt(args[1]); //day of the month

		if(D > 31 || D < 1 || S > 7 || S < 1) System.out.println("?");

		else{
			for(y = 1; y<=400; y++){
				if (y % 100 == 0) leapYear = false;
				else leapYear = (y % 4 == 0 && y>=4);
				for(m=1; m<=12; m++){
					if(leapYear == false){
						days[2] = 28;
						for(d=1; d<=days[m]; d++){
							if(d == D && s == S){
								if(temp > resp) resp = temp;
								temp = 0;
							}
							else temp++;
							if(s == 7) s = 0;
							s++;
						}
					}	
					if(leapYear == true){
						days[2] = 29;
						for(d=1; d<=days[m]; d++){
							if(d == D && s == S){
								if(temp > resp) resp = temp;
								temp = 0;
							}
							else temp++;
							if(s == 7) s = 0;
							s++;
						}
					}
				}
			}
			System.out.println(resp);
		}
	}
}