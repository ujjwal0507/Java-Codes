package DSA2.Graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
    
    Map<Integer, List<Integer>> graph;

    public Graph(){
        graph = new HashMap<>();
    }

    public void addNode(int val){
        graph.put(val, new ArrayList<>());
    }

    public void addEdge(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void dfs(){
        dfs(1, new HashSet<>());
        System.out.println();
    }

    public void dfs(int curNode, Set<Integer> visited){
        if(visited.contains(curNode)) return;

        System.out.print(curNode+" ");

        visited.add(curNode);

        for(int neighbor: graph.get(curNode)){
            dfs(neighbor, visited);
        }
    }

    public void bfs(){
        bfs(1);
        System.out.println();
    }

    public void bfs(int node){

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(node);

        while(!queue.isEmpty()){
            int curNode = queue.remove();
            if(visited.contains(curNode)) continue;
            System.out.print(curNode+" ");
            visited.add(curNode);
            for(int neighbor: graph.get(curNode)){
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                }
            }
        }
        
        System.out.println();
    }

}

class Main{
    
    public static void main(String[] args){

        Graph graph = new Graph();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        

        graph.addEdge(1, 2);
        // graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        // graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.dfs();

        graph.bfs();


    }

}