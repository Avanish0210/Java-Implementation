import java.util.ArrayList;

public class UndirectedGraph {
    static class Edge{
        int src;
        int dest;

        public Edge(int s , int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        //this loop is imp bcause here in array there is null everywhere and this for loop it creates an empty list so that we can store edges their
        for(int i=0 ; i<graph.length ; i++){
            graph[i]= new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1 ));
        graph[0].add(new Edge(0, 4 ));

        graph[1].add(new Edge(1, 0 ));
        graph[1].add(new Edge(1, 2 ));
        graph[1].add(new Edge(1, 4 ));

        graph[2].add(new Edge(2, 1 ));
        graph[2].add(new Edge(2, 3 ));
        

        graph[3].add(new Edge(3, 2 ));

        graph[4].add(new Edge(4, 0 ));
        graph[4].add(new Edge(4, 1 ));
        graph[4].add(new Edge(4, 5 ));

        graph[5].add(new Edge(5, 4 ));

    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[] , boolean vis[] , int curr , int  par){
        vis[curr]=true;

        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(vis[curr]==true && par!=e.dest){
                return true;
            }
            if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
        
    }
    public static void main(String[] args){
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        boolean vis[] = new boolean[v];

        System.out.println(isCycleDirected(graph, vis, 0, -1));

        
    }
}
