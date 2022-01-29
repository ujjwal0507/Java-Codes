import java.util.*;

class WeightedGraph {
    int[][] graph;
    int V,E;

    public WeightedGraph(int[][] gr){
        System.out.println(gr.length);
        this.V = gr.length;
        this.E = 0;
        this.graph = new int[V][V];
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++){
                graph[i][j] = gr[i][j];
            }
    }

    public int min_index(int[] distance, Set<Integer> visited){
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int i=0;i<V;i++){
            if(distance[i]<min && !visited.contains(i)){
                min = distance[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public void dijkstra(int src, int dest){
        Set<Integer> visited = new HashSet<Integer>();
        int[] dist = new int[V];
        int[] pred = new int[V];
        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        pred[src] = -1;
        for(int i=0;i<V-1;i++){
            int cur = min_index(dist, visited);
            visited.add(cur);
            if(cur==dest)
                break;
            for(int v=0;v<V;v++){
                if(graph[cur][v]!=0 && !visited.contains(v) && (dist[cur]+graph[cur][v]<dist[v])){
                    dist[v] = dist[cur]+graph[cur][v];
                    pred[v] = cur;
                }
            }
        }
        System.out.println("Vertex\tMinimum Distance\tPredecesor");
        for(int i=0;i<V;i++){
            System.out.println(i+"\t"+dist[i]+"\t\t"+pred[i]);
        }
        if(!visited.contains(dest)){
            System.out.println("No path exisits");
            return;
        }
        Stack<Integer> path = new Stack<>();
        path.push(dest);
        while(pred[path.peek()]!=-1)
            path.push(pred[path.peek()]);
        System.out.println("Length of path: "+dist[dest]);
        System.out.print("The actual path: ");
        while(!path.isEmpty())
            System.out.print(path.pop()+" ");
        System.out.println();
    }
    
    public static void main(String[] args){
        int[][] adj_mat = new int[][]{{0,2,4,0,0,0},
                                      {0,0,1,2,0,0},
                                      {0,0,0,0,0,0},
                                      {0,0,0,0,0,1},
                                      {0,0,0,2,0,5},
                                      {0,0,0,0,0,0}}; 
        WeightedGraph graph = new WeightedGraph(adj_mat);
        graph.dijkstra(0,5);
    }
}