import java.util.*;
public class RatInAMaze {
    public static int[][] maze;
    public static int ways = 0;

    public static void solve(int[][] maze, int row, int col){
        if(row==maze.length || col==maze.length)
            return;
        if(row==maze.length-1 && col==maze.length-1){
            ways++;
            return;
        }
        if(maze[row][col]==0)
            return;
        else{
            solve(maze, row, col+1);
            solve(maze, row+1, col);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        maze = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                maze[i][j] = sc.nextInt();
        solve(maze, 0, 0);
        System.out.println(ways);
        sc.close();
    }
}