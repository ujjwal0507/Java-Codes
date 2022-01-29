import java.util.*;

public class NQueens{

    public static boolean isSafe(int n, List<Integer> cur, int row, int col){
        if(row==n || col==n)
            return false;
        int[][] grid = new int[n][n];
        for(int i=0;i<cur.size();i++){
            grid[i][cur.get(i)] = 1;
        }
        for(int i=0;i<n;i++){
            if(grid[row][i]==1)
                return false;
        }
        for(int i=0;i<n;i++){
            if(grid[i][col]==1)
                return false;
        }
        int r1 = row, c1=col;
        while(r1>=0 && c1>=0){
            if(grid[r1--][c1--]==1)
                return false;
        }
        r1 = row; c1=col;
        while(r1>=0 && c1<n){
            if(grid[r1--][c1++]==1)
                return false;
        }
        r1 = row; c1=col;
        while(r1<n && c1>=0){
            if(grid[r1++][c1--]==1)
                return false;
        }
        r1 = row; c1=col;
        while(r1<n && c1<n){
            if(grid[r1++][c1++]==1)
                return false;
        }
        
        return true;
    }

    public static void solve(int n, int i, List<Integer> cur, List<List<Integer>> result){
        if(i==n){
            List<Integer> ans = new ArrayList<>();
            for(int el: cur)
                ans.add(el);
            result.add(ans);
            
        }
        else{
            for(int col=0;col<n;col++){
                if(isSafe(n, cur, cur.size(), col)){
                    cur.add(col);
                    solve(n,i+1, cur, result);
                }
            }
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args){
        int n = 4;
        List<List<Integer>> result = new ArrayList<>();
        solve(n, 0,new ArrayList<>(), result);
        System.out.println(result);
    }
}