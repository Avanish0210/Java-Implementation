import java.util.*;

class KruskalsAlgo {

    class Edge {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // Find with path compression
        int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        // Union by rank
        boolean union(int x, int y) {

            int px = find(x);
            int py = find(y);

            // Already connected -> adding this edge creates a cycle
            if (px == py) {
                return false;
            }

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } 
            else if (rank[px] > rank[py]) {
                parent[py] = px;
            } 
            else {
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }

    public int kruskal(int V, int[][] edges) {

        // Convert edges into Edge objects
        List<Edge> list = new ArrayList<>();

        for (int[] edge : edges) {
            list.add(new Edge(edge[0], edge[1], edge[2]));
        }

        // Sort edges according to weight
        list.sort((a, b) -> a.wt - b.wt);

        DSU dsu = new DSU(V);

        int mstWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : list) {

            // If they belong to different components,
            // adding this edge will NOT create a cycle
            if (dsu.union(edge.u, edge.v)) {

                mstWeight += edge.wt;
                edgesUsed++;

                // MST needs exactly V - 1 edges
                if (edgesUsed == V - 1) {
                    break;
                }
            }
        }

        return mstWeight;
    }
}