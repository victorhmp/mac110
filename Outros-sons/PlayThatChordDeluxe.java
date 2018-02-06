/******************************************************************************
 *
 *  MAC0110 - Introdução à Computação
 *  Aluno: Victor Hugo Miranda Pinto
 *  Numero USP: 10297720
 *  Tarefa: Ex. 5 (Outros sons)
 *  Data: 07/05/2017
 *
 *  Baseado em PlayThatTuneDeluxe.java / PlayThatChord.java
 *
 *  DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 *  PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 *  PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 *  FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 *  AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 *  DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class PlayThatChordDeluxe {
    
    //averages the pitches to create the final sound
    public static double[] avg(double[] a, double[] b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++){
            c[i] = a[i]/2.0 + b[i]/2.0;
        }
        return c;
    }
    // Karpus-Strong (no args)
    public static double[] wave(double hz, double d) { 
        int n = (int)(44100*d);
        int p = Math.abs((int)(44100/hz));
        
        if(p > n){
            double[] a = new double[p+10];
            for(int i = 0; i<p; i++){
                a[i] = 0.0;
            }
            return a;
        }
        else{
            double[] a = new double[n+10];
           for(int i = 0; i<p; i++){
                a[i] = Math.random()*2 - 1;
            }
            for (int i = p, j=0; i <= n; i++, j++) {
                a[i] = .997*(a[j] + a[j+1])/2;
            }
            return a;
        }
    }
    // Karpus-Strong alternative (with args)
    public static double[] wave_alt(double hz, double d) { 
        int n = (int)(44100*d);
        int p = Math.abs((int)(44100/hz));
        
        if(p > n){
            double[] a = new double[p+10];
            for(int i = 0; i<p; i++){
                a[i] = 0.0;
            }
            return a;
        }
        else{
            double[] a = new double[n+10];
           for(int i = 0; i<p; i++){
                a[i] = Math.random()*2 - 1;
            }
            for (int i = p, j=0; i <= n; i++, j++) {
                a[i] = .997*(8*a[j] + a[j+2] + a[j+8])/10;
            }
            return a;
        }
    }
    // no args
    public static double[] chord(int[] pitch, double d) {
        double hz1 = Math.abs(220.0 * Math.pow(2, pitch[0] / 12.0));
        double hz2 = Math.abs(220.0 * Math.pow(2, pitch[1] / 12.0));
        double[] a = wave(hz1, d);
        double[] b = wave(hz2, d);
        return avg(a, b);
    }
    // with args
    public static double[] chord_alt(int[] pitch, double d) {
        double hz1 = Math.abs(220.0 * Math.pow(2, pitch[0] / 12.0));
        double hz2 = Math.abs(220.0 * Math.pow(2, pitch[1] / 12.0));
        double[] a = wave_alt(hz1, d);
        double[] b = wave_alt(hz2, d);
        return avg(a, b);
    }
    
    public static void main(String[] args) {
        //read standart input while there is input
        while(!StdIn.isEmpty()){
            String s = StdIn.readLine();
            s = s.trim();
            String[] t = s.split("\\s+");
            int[] pitch = new int[t.length];
            for(int i=0;i<pitch.length;i++) pitch[i] = 0;

            if(t.length > 1){ // checks if t[i] is not an empty string
                for(int i=0; i<t.length; i++){
                    double in = Double.parseDouble(t[i]);
                    if(in == (int)in){
                            if(in > -50){
                                pitch[i] = (int)in;
                            }
                            else pitch[i] = 0;
                    }
                    else{
                        double duration = in;
                        if(args.length < 1){ // no args, call the standard Karpus-Strong algorithm
                            double[] a = chord(pitch, duration);
                            StdAudio.play(a);
                        }
                        else{ // with args, call alternative algorithm
                            double[] a = chord_alt(pitch, duration);
                            StdAudio.play(a);
                        }
                    }
                }
            }

        }

    }
}