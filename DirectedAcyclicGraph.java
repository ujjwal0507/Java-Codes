import java.util.*;

public class DirectedAcyclicGraph {
    Map<Integer, List<Integer>> graph;
    int V,E, size;
    public DirectedAcyclicGraph(int V){
        this.V = V;
        this.E = 0;
        this.graph = new HashMap<Integer, List<Integer>>();
    }

    public void addVertex(int v){
        if(size<V){
            graph.put(v,new ArrayList<Integer>());
            size++;
        }
    }

    public void addEdge(int src, int dest){
        List<Integer> next = graph.get(src);
        next.add(dest);
        graph.put(src, next);
    }

    public void dfs(int src, Set<Integer> visited, List<Integer> order){
        Stack<Integer> stack = new Stack<Integer>();
        if(!visited.contains(src)){
            stack.push(src);
            while(!stack.isEmpty()){
                int cur = stack.pop();
                order.add(cur);
                visited.add(cur);
                for(int adj: graph.get(cur)){
                    if(!visited.contains(adj))
                        stack.push(adj);
                }
            }
        }
    }

    public void topologicalSort(){
        Set<Integer> visited = new HashSet<>();
        String sorted = "";
        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            List<Integer> order = new ArrayList<>();
            dfs(entry.getKey(), visited, order);
            String cur_order = "";
            for(int ch: order)
                cur_order +=ch;
            sorted = cur_order+sorted;
        }
        System.out.println("Topological Sorting of the graph: "+sorted);
    }
    
    public static void main(String[] args){
        DirectedAcyclicGraph graph = new DirectedAcyclicGraph(6);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.addEdge(5,1);
        graph.addEdge(5,2);
        graph.addEdge(6,1);
        graph.addEdge(6,3);
        graph.topologicalSort();
    }
}