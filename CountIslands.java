import java.util.*;

public class CountIslands {

    public void explore(int[][] mat, int row, int col, Set<Integer> visited){
        int V = mat.length;
        if(row<0 || col<0 || row>=V || col>=V)
            return;
        if(mat[row][col]==0)
            return;
        if(visited.contains(row*V+col))
            return;
        visited.add(row*V+col);
        explore(mat, row-1, col-1, visited);
        explore(mat, row-1, col, visited);
        explore(mat, row-1, col+1, visited);
        explore(mat, row, col-1, visited);
        explore(mat, row, col+1, visited);
        explore(mat, row+1, col-1, visited);
        explore(mat, row+1, col, visited);
        explore(mat, row+1, col+1, visited);
    }

    public void countIslands(int[][] mat){
        Set<Integer> visited = new HashSet<>();
        int V = mat.length;
        int ctr = 0;
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(!visited.contains(i*V+j) && mat[i][j]==1){
                    explore(mat, i, j, visited);
                    ctr++;
                    System.out.println(visited);
                }
            }
        }
        System.out.println("The number of islands on the matrix is: "+ ctr );
    }

    public static void main(String[] args){
        int[][] mat = new int[][]{{1, 1, 0, 0, 0},
                                  {0, 1, 0, 0, 1},
                                  {1, 0, 0, 1, 1},
                                  {0, 0, 0, 0, 0},
                                  {1, 0, 1, 0, 1}};
        CountIslands obj = new CountIslands();
        obj.countIslands(mat);
    }
}