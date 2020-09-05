import java.util.*;

public class KnightTour {

    static int moves = 0;

    public static void solve(int[][] mat, int row, int col){
        if(row<0 || col<0 || row>=mat.length || col>=mat.length){
            return;
        }
        if(mat[row][col]!=-1)
            return;
        
        mat[row][col] = moves++;
        solve(mat, row+2, col+1);
        solve(mat, row+2, col-1);
        solve(mat, row-2, col+1);
        solve(mat, row-2, col-1);
        solve(mat, row+1, col+2);
        solve(mat, row+1, col-2);
        solve(mat, row-1, col+2);
        solve(mat, row-1, col-2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                mat[i][j] = -1;
        solve(mat, 0,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }*/
        System.out.println(-239%5);
        sc.close();
    }
}