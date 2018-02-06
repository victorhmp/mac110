/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Variante final do Web Ex. 2.1.5 (Voting machines)
 *  Data: 20/06/2017
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class VotingPlot{
    
    // recursive curve plotting
    public static void curve(int n, double x0, double y0, double x1, double y1, int t, double a) {
        double gap = 0.01;
        double err = 0.0025;

        double xm = (x0 + x1) / 2;

        double ym = (y0 + y1) / 2;

        double fxm = p(n, a, xm, t);


        if (x1 - x0 < gap || Math.abs(ym - fxm) < err) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        curve(n, x0, y0, xm, fxm, t, a);
        StdDraw.filledCircle(xm, fxm, 0.005);
        curve(n, xm, fxm, x1, y1, t, a);
    }

    // simulate each voter's vote
    public static int voting(double f, int res){
        // 0 = A && 1 = B;
        double r = Math.random();
        if(r <= f && res == 0) res = 1;
        else if(r <= f && res == 1) res = 0;

        return res; 
    }

    // calculates p(n,a,f) t times
    public static double p(int n, double a, double f, int t){
        double wa = 0;
        int winner = 0; // candidate A
        int areal = (int) Math.ceil(n*a); // number of votes for candidate A
        int counter = 1;
        while(counter<=t){
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

        return wa/t;
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        double a = Double.parseDouble(args[1]);
        int t = Integer.parseInt(args[2]);
        
        StdDraw.setScale(-0.05, 1.05);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(0.5,0.0,0.5,1.0);
        StdDraw.line(0.0,0.03,1.0,0.03);
        StdDraw.setPenColor(StdDraw.BLACK);
        curve(n, 0.0, 0.0, 1.0, 1.0, t, a);
    }


}    