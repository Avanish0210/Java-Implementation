import java.util.*;
public class Graphs {
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
        graph[0].add(new Edge(0, 2 ));

        graph[1].add(new Edge(1, 0 ));
        graph[1].add(new Edge(1, 3 ));

        graph[2].add(new Edge(2, 0 ));
        graph[2].add(new Edge(2, 4 ));

        graph[3].add(new Edge(3, 1 ));
        graph[3].add(new Edge(3, 4 ));
        graph[3].add(new Edge(3, 5 ));

        graph[4].add(new Edge(4, 2 ));
        graph[4].add(new Edge(4, 3 ));
        graph[4].add(new Edge(4, 5 ));

        graph[5].add(new Edge(5, 3 ));
        graph[5].add(new Edge(5, 4 ));
        graph[5].add(new Edge(5, 6 ));

        graph[6].add(new Edge(6, 5 ));
    }

    public static void bfs(ArrayList<Edge> graph[] , int v , boolean vis[] , int st){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.println(curr + " ");
                vis[curr] = true;

                for(int i=0 ; i<graph[curr].size() ; i++){
                    Edge e  = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static  void dfs(ArrayList<Edge> graph[] , int curr , boolean vis[]){
        System.out.println(curr + "  ");
        vis[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==false){
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static void printAllPath(ArrayList<Edge> graph[] , boolean vis[] , int curr , String path ,int tar){
        if(curr==tar){
            System.out.println(path);
            return;
        }
        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==false){
                vis[curr] = true;
                printAllPath(graph, vis, e.dest, path+e.dest , tar);
                vis[curr]=false;
            }
        }

    }
    public static void main(String [] args){
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        //this for loop if you have disconnected grph othervise declare boolean in bfs function and start from 0
        boolean vis[] = new boolean[v];
        // for(int i=0 ; i<v ; i++){
        //     if(vis[i]==false){
        //         bfs(graph, v , vis , i);
        //     }
        // } 

        // dfs(graph, 0, vis);
        int src = 0 , tar = 5;
        printAllPath(graph, vis, src , "0", tar);

        System.out.println();
    }
    
}
