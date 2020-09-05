import java.util.*;

class Edge implements Comparable<Edge>{
    int src,dest,weight;
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e){
        if(this.weight<e.weight)
            return -1;
        if(this.weight>e.weight)
            return 1;
        return 0;
    }

    public void printEdge(){
        System.out.println(this.src+"\t"+this.dest+"\t"+this.weight);
    }
}

public class SpanningTree {
    int[][] graph;
    int V;
    int E;

    public SpanningTree(int[][] gr){
        this.V = gr.length;
        this.graph = new int[V][V];
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++)
                this.graph[i][j] = gr[i][j];
        this.E = 0;
    }

    public int min_index(int[] distance, Set<Integer> visited){
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int i=0;i<V;i++)
            if(distance[i]<min && !visited.contains(i)){
                min = distance[i];
                min_index = i;
            }
        return min_index;
    }

    public void prims(){
        int[] pred = new int[V];
        int[] distance = new int[V];
        Set<Integer> visited = new HashSet<Integer>();
        for(int i=0;i<V;i++)
            distance[i] = Integer.MAX_VALUE;
        distance[0] = 0;
        pred[0] = -1;
        for(int i=0;i<V-1;i++){
            int cur = min_index(distance, visited);
            visited.add(cur);
            for(int v=0;v<V;v++){
                if(graph[cur][v]!=0 && !visited.contains(v) && graph[cur][v]<distance[v]){
                    distance[v] = graph[cur][v];
                    pred[v] = cur;
                }
            }
        }
        int sum = 0;
        for(int i=0;i<V;i++)
            sum+=distance[i];
        System.out.println("Cost of the minimum spanning tree: "+sum);
        for(int i=0;i<V;i++)
            System.out.println(i+"\t"+pred[i]);
    }

    public List<Edge> getEdgeList(){
        List<Edge> list = new ArrayList<Edge>();
        for(int i=0;i<V-1;i++){
            for(int j=i+1;j<V;j++){
                if(graph[i][j]!=0)
                    list.add(new Edge(i,j,graph[i][j]));
            }
        }
        Collections.sort(list);
        return list;
    }

    public void kruskal(){
        List<Edge> edgeList = getEdgeList();
        int cur =0;
        Set<Edge> spaning = new HashSet<Edge>();
        while(spaning.size()!=V-1){
            spaning.add(edgeList.get(cur++));
            if(isCycle(spaning)){
                spaning.remove(edgeList.get(cur-1));
                
            }
        }
        for(Edge edge: spaning)
            edge.printEdge();
    }

    public int find(int[] parent, int src){
        if(parent[src]==-1)
            return src;
        return find(parent, parent[src]);
    }

    public void Union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[yset] = xset;
    }
    
    public boolean isCycle(Set<Edge> edgeList){
        int[] parent = new int[V];
        for(int i=0;i<V;i++)
            parent[i] = -1;
        for(Edge edge: edgeList){
            if(find(parent, edge.src)==find(parent, edge.dest))
                return true;
            else
                Union(parent, edge.src, edge.dest);
        }
        
        return false;

    }
    

    public static void main(String[] args){
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
        { 2, 0, 3, 8, 5 }, 
        { 0, 3, 0, 0, 7 }, 
        { 6, 8, 0, 0, 9 }, 
        { 0, 5, 7, 9, 0 } }; 
        SpanningTree st = new SpanningTree(graph);
        st.kruskal();
    }
}


