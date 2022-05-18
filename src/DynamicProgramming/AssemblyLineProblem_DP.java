package DynamicProgramming;

public class AssemblyLineProblem_DP {
    public static int assemblyLine(int n, int[][] a, int[][] T, int[] e, int[] x){
        int[] line1 = new int[n];
        int[] line2 = new int[n];

        line1[0] = e[0] + a[0][0];
        line2[0] = e[1] + a[1][0];

        for(int i =1; i<n; i++){
            line1[i] = Math.min(a[0][i] + line1[i-1], a[0][i] + line2[i-1] + T[1][i]);
            line2[i] = Math.min(a[1][i] + line2[i-1], a[1][i] + line1[i-1] + T[0][i]);
        }

        return Math.min(line1[n-1] + x[0], line2[n-1] + x[1]);
    }

    public static void main(String[] args) {
        int[][] a = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int[][] t = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int[] e = {10, 12}, x = {18, 7};

        System.out.println(assemblyLine(4,a, t, e, x));
    }
}
