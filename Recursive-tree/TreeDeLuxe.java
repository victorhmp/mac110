/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Variante do Creative Ex. 2.3.33 (Recursive tree)
 *  Data: 21/05/2017
 *
 *  Baseado em Tree.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class TreeDeLuxe {

	public static void tree(int n, double x, double y, double a, double branchRadius, int bA, int brA, double brRt) {
        double bendAngle   = Math.toRadians(bA);
        double branchAngle = Math.toRadians(brA);
        double branchRatio = brRt;

        double cx = x + Math.cos(a) * branchRadius;
        double cy = y + Math.sin(a) * branchRadius;
        StdDraw.setPenRadius(0.001 * Math.pow(n, 1.2));
        StdDraw.line(x, y, cx, cy);
        if (n == 0) return;

        tree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio, bA, brA, brRt);
        tree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio, bA, brA, brRt);
        tree(n-1, cx, cy, a + bendAngle,               branchRadius * (1 - branchRatio), bA, brA, brRt);
    }

    public static void main(String[] args) {
    	// input: N, a, branchRadius, bendAngle, branchAngle, branchRatio
        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        double brR = Double.parseDouble(args[2]);
        int bA = Integer.parseInt(args[3]);
        int brA = Integer.parseInt(args[4]);
        double brRt = Double.parseDouble(args[5]);

        StdDraw.enableDoubleBuffering();
        tree(n, 0.5, 0, Math.toRadians(a), brR, bA, brA, brRt);
        StdDraw.show();
        StdDraw.save("tree-"+n+"-"+a+"-"+brR+"-"+bA+"-"+brA+"-"+brRt+".jpg");
    }
}