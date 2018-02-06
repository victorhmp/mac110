public class Queens {

   /***************************************************************************
    * Return true if queen placement q[n] does not conflict with
    * other queens q[0] through q[n-1]
    ***************************************************************************/
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) return false;   // same column
        }
        return true;
    }

   /***************************************************************************
    * Prints n-by-n placement of queens from permutation q in ASCII.
    ***************************************************************************/

    // 2D array with every valid line
    public static int[][] lines = new int[1000][10];

    public static void printQueens(int[] q, int s) {
        int n = q.length;
        int[] line = new int[s];
        int k = 0, ki=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j){
                    StdOut.print("Q ");
                    line[k++] = j;
                }
                else
                    StdOut.print("* ");
            }
            StdOut.println();
        }  
        StdOut.println();
        for(int i=0;i<s;i++){
            lines[ki][i] = line[i];
        }
        ki++;
    }


   /***************************************************************************
    *  Try all permutations using backtracking
    ***************************************************************************/
    public static void enumerate(int n) {
        int[] a = new int[n];
        enumerate(a, 0, n);
    }

    public static void enumerate(int[] q, int k, int s) {
        int n = q.length;
        if (k == n) printQueens(q, s);
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) enumerate(q, k+1, s);
            }
        }
    }  


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        enumerate(n);
    }

}