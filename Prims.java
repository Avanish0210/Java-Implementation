import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    public static class Edge{
        int src ;
        int dest;
        int wt;
        Edge(int s , int d , int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static class Pair{
        int node;
        int cost;
        Pair(int node , int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public  static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0 ; i<graph.length ; i++){
            graph[i]= new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    static void primsAlgo(ArrayList<Edge> graph[] , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);

        boolean[] vis = new boolean[V];
        pq.add(new Pair(0,0));
        int mstCost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                mstCost+=curr.cost;
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e= graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest , e.wt));
                    }
                }
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primsAlgo(graph, V);
    }
}
