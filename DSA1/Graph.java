import java.util.*;

public class Graph {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int V, E, size;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        this.size = 0;
    }

    public void addVertex(int n){
        if(size<V){
            graph.putIfAbsent(n, new ArrayList<Integer>());
            size++;
            System.out.println("Vertex "+n+" inserted.");
        }
        else
            System.out.println("Graph is full. Delete vertices in order to insert");
    }

    public void addEdge(int v1, int v2){
        if(v1==v2){
            graph.get(v1).add(v1);
        }
        else{
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
            System.out.println("Edge added between "+v1+" and "+v2);
        }   
    }

    public void printNeighbours(int v1){
        List<Integer> neighbours = graph.get(v1);
        System.out.print("All neighbours of the vertex "+v1+" are: ");
        for(int i=0;i<neighbours.size();i++){
            System.out.print(neighbours.get(i)+" ");
        }
        System.out.println();
    }

    public void printAllVertex(){
        System.out.print("Vertices in the graph: ");
        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet())
            System.out.print(entry.getKey()+" ");
        System.out.println();
    }

    public void removeVertex(int v1){
        graph.remove(v1);
        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            List<Integer> neigh = entry.getValue();
            neigh.remove(v1);
            graph.put(entry.getKey(), neigh);
        }
    }
    
    public void removeEdge(int v1, int v2){
        List<Integer> neigh1 = graph.get(v1);
        List<Integer> neigh2 = graph.get(v2);
        if(neigh1.contains(v2)){
            neigh1.remove(v2);
            graph.put(v1, neigh1);
        }
        if(neigh2.contains(v1)){
            neigh2.remove(v1);
            graph.put(v2, neigh2);
        }
    }

    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            printNeighbours(entry.getKey());
        }
    }

    public void bfs(int v1){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited  = new LinkedHashSet<>();
        queue.add(v1);
        System.out.print("BFS Traversal of the graph: ");
        while(!queue.isEmpty()){
            int cur = queue.remove();
            if(!visited.contains(cur)){
                System.out.print(cur+" ");
                visited.add(cur);
                List<Integer> neighbours = graph.get(cur);
                for(int neigh: neighbours)
                    queue.add(neigh);
            }
        }
        visited = new HashSet<Integer>();
        System.out.println();
    }

    public void dfs(int v1){
        System.out.print("DFS Traversal of the graph: ");
        dfs(v1, new LinkedHashSet<Integer>());
        System.out.println();
    }

    public void dfs(int v1, Set<Integer> visited){
        if(visited.contains(v1))
            return;
            visited.add(v1);
            System.out.print(v1+" ");
        for(int i: graph.get(v1)){
            dfs(i, visited);
        }
    }

    public void stackDfs(int v1){
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> visited = new LinkedHashSet<Integer>();
        stack.push(v1);
        System.out.print("DFS Traversal using Stack: ");
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(!visited.contains(cur)){
                System.out.print(cur+" ");
                visited.add(cur);
                for(int i: graph.get(cur)){
                    if(!visited.contains(i)){
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println();
    }

    public boolean isCyclic(){
        int node = 0;
        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            node = entry.getKey();
            break;
        }
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        stack.push(node);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(visited.contains(cur))
                return true;
            visited.add(cur);
            for(int adj: graph.get(cur)){
                if(!visited.contains(adj))
                    stack.push(adj);
                if(adj==cur)
                    return true;
            }
       }
       return false;
   }

    public void shortestPath(int src, int dest){
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(src);
        map.put(src,-1);
        while(!queue.isEmpty()){
            int cur = queue.remove();
            if(!visited.contains(cur)){
                visited.add(cur);
                for(int adj: graph.get(cur)){
                    map.putIfAbsent(adj, cur);
                    if(!visited.contains(adj))
                        queue.add(adj);
                }
            }
        }
        if(!visited.contains(dest)){
            System.out.println("No path exists.");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(dest);
        while(map.get(stack.peek())!=-1){
            stack.push(map.get(stack.peek()));
        }
        System.out.println("Length of the shortest path: "+(stack.size()-1));
        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
        
    }

    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        
        graph.printAllVertex();
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        
        graph.printGraph();
    
        graph.shortestPath(3, 6);   
    }
}