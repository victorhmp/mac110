/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 4 (Bilhar)
 *  Data: 07/05/2017
 *
 *  Baseado em BouncingBall.java / MouseFollower.java / OneSimpleAttractor.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class Billiards {
    public static void main(String[] args) {
        double rx = 0.5, ry = 0.5;   // position
        double vx = 0.0, vy = 0.0;   // velocity
        double mass = 2.0;           // mass
        double dt   = 0.5;           // time quantum
        double drag = 0.005;         // drag coefficient
        double radius = 0.1;         // ball radius
        double strength = 0.1;       // strength constant
        double fx = 0;               // force in the x-axis
        double fy = 0;               // force in the y-axis
        
        // do the animation
        StdDraw.setXscale(-2.0, 2.0);
        StdDraw.setYscale(-2.0, 2.0);
        StdDraw.enableDoubleBuffering();
        while (true) {

            if(StdDraw.mousePressed()){
                // compute the distance mouse-ball
                double dx = StdDraw.mouseX()-rx;
                double dy = StdDraw.mouseY()-ry;

                //compute the force applied by the mouse, accounting for drag
                fx = (strength/dx) - (drag * vx);
                fy = (strength/dy) - (drag * vy);

                //update the velocity
                vx += -fx * dt / mass;
                vy += -fy * dt / mass;
            }
            //loss of velocity due to drag force
            vx *= 1-drag;
            vy *= 1-drag;

            //update position
            rx += (vx * dt);
            ry += (vy * dt);

            //check for collisions with the walls (elastic collision)
            if (Math.abs(rx + vx) > 2.0 - radius) vx = -vx;
            if (Math.abs(ry + vy) > 2.0 - radius) vy = -vy;
            
            
            StdDraw.clear(StdDraw.LIGHT_GRAY);

            //blink on mouse press
            if(StdDraw.mousePressed()){
                StdDraw.clear(StdDraw.WHITE);
            }

            // draw particle
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show();
            StdDraw.pause(5);
        }
    }
}