/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Web Ex. 1.5.16 (Spiral)
 *  Data: 30/04/2017
 *
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

class Spiral{
	public static void main(String[] args) {

    	StdDraw.setPenRadius(0.01);
    	StdDraw.setXscale(0.0, 50.0);
    	StdDraw.setYscale(0.0, 50.0);

        //PROCESSO AUTOMATICO

    	for(double i = 0.0; i <= 23.0; i++){
    		StdDraw.line(1.0+i, 1.0+i, 49.0-i, 1.0+i); //left-right
    		StdDraw.line(49.0-i, 1.0+i, 49.0-i, 49.0-i); //up
    		StdDraw.line(49.0-i, 49.0-i, 2.0+i, 49.0-i); //right-left
    		StdDraw.line(2.0+i, 49.0-i, 2.0+i, 2.0+i); //down
    	}

        /*
        COMANDOS PARA DESENHAR A ESPIRAL:

        StdDraw.line(1.0, 1.0, 49.0, 1.0); //left-right
        StdDraw.line(49.0, 1.0, 49.0, 49.0); //up
        StdDraw.line(49.0, 49.0, 2.0, 49.0); //right-left
        StdDraw.line(2.0, 49.0, 2.0, 2.0); //down

        StdDraw.line(2.0, 2.0, 48.0, 2.0); //left-right
        StdDraw.line(48.0, 2.0, 48.0, 48.0); //up
        StdDraw.line(48.0, 48.0, 3.0, 48.0); //right-left
        StdDraw.line(3.0, 48.0, 3.0, 3.0); //down

                    .
                    .
                    .

        StdDraw.line(24.0, 24.0, 26.0, 24.0); //left-right
        StdDraw.line(26.0, 23.0, 26.0, 26.0); //up
        StdDraw.line(26.0, 26.0, 25.0, 26.0); //right-left
        StdDraw.line(25.0, 26.0, 25.0, 25.0); //down

        */
	}
}