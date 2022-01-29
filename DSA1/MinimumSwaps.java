import java.io.*;
import java.util.*;

public class MinimumSwaps{

    public static int minimum(int[] dist, Set<Integer> visited){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<dist.length;i++){
            if(!visited.contains(i) && min>dist[i]){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    public static int getMin(int[][] graph){
        int[] dist = new int[graph.length];
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<dist.length;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;
        for(int i=0;i<graph.length-1;i++){
            int min = minimum(dist, visited);
            visited.add(min);
            for(int j=0;j<graph.length;j++){
                if(graph[min][j]!=0 && !visited.contains(j) && graph[min][j]<dist[j]){
                    dist[j] = graph[min][j];
                }
            }
        }
        int sum = 0;
        for(int i: dist)
            sum+=i;
        return sum;
    }

    public static void main(String[] args)throws IOException{
        int[][] graph = new int[][]{{0, 1, 1, 100, 0, 0}, 
        {1, 0, 1, 0, 0, 0}, 
        {1, 1, 0, 0, 0, 0},    
        {100, 0, 0, 0, 2, 2}, 
        {0, 0, 0, 2, 0, 2},   
        {0, 0, 0, 2, 2, 0}};
        System.out.println(getMin(graph));
    }
}