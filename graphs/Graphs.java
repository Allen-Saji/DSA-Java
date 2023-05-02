package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graphs {

    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    // O(V+E)
    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // source 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) { // visit the current
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    // O(V+e)
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    // static class Pair implements Comparable<Pair> {
    // int n; // node
    // int path;

    // public Pair(int n, int path) {
    // this.n = n;
    // this.path = path;
    // }

    // @Override
    // public int compareTo(Pair p2) {
    // return this.path - p2.path; // path based sorting for pairs
    // }
    // }

    // tc:

    // O(V+ElogV) because we used priority queue else O(V^2)
    // ElogV PQ ke dist ki sorting ka time h

    // public static void dijkstra(ArrayList<Edge> graph[], int src, int dest) {
    // int dist[] = new int[graph.length]; // dist[i]: dist from src to i
    // for (int i = 0; i < graph.length; i++) {
    // if (i != src) {
    // dist[i] = Integer.MAX_VALUE;
    // }
    // }

    // boolean vis[] = new boolean[graph.length];
    // PriorityQueue<Pair> pq = new PriorityQueue<>();
    // pq.add(new Pair(src, 0));
    // // loop
    // while (!pq.isEmpty()) {
    // Pair curr = pq.remove();
    // if (!vis[curr.n]) {
    // vis[curr.n] = true;
    // }
    // for (int i = 0; i < graph[curr.n].size(); i++) {
    // Edge e = graph[curr.n].get(i);
    // int u = e.src;
    // int v = e.dest;
    // int wt = e.dest;

    // if (dist[u] + wt < dist[v]) {
    // dist[v] = dist[u] + wt;
    // pq.add(new Pair(v, dist[v]));
    // }
    // }
    // }
    // // print all src to dest shortest path
    // for (int i = 0; i < graph.length; i++) {
    // System.out.print(dist[i] + " ");
    // }
    // System.out.println();
    // }

    // // TC: O(V+E)
    // public static void bellmanFord(ArrayList<Edge> graph[], int src) {
    // int dist[] = new int[graph.length];
    // for (int i = 0; i < graph.length; i++) {
    // if (i != src) {
    // dist[i] = Integer.MAX_VALUE;
    // }
    // }

    // int V = graph.length;

    // for (int i = 0; i < V - 1; i++) {
    // // TC = no. of edges i.e. O(E)
    // for (int j = 0; j < graph.length; j++) {
    // for (int k = 0; k < graph[j].size(); k++) {
    // Edge e = graph[j].get(k);
    // int u = e.src;
    // int v = e.dest;
    // int wt = e.wt;

    // if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
    // dist[v] = dist[u] + wt;
    // }
    // }
    // }
    // }

    // for (int i = 0; i < dist.length; i++) {
    // System.out.print(dist[i] + " ");
    // }
    // }

    static class Pair implements Comparable<Pair> {
        int v, cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("Cost of MST: " + finalCost);
    }

    public static void main(String[] args) {
        int V = 5; // no. of vertices of graph
        ArrayList<Edge>[] graph = new ArrayList[V]; // array of arraylist
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // 1st vertex
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        // graph[1].add(new Edge(1, 3, 3));

        // 2nd vertex
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        // graph[2].add(new Edge(2, 3, 1));

        // 3rd vertex
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        // 4th vertex
        // graph[4].add(new Edge(4, 2, 4));

        // 2's neighbours
        // for (int i = 0; i < graph[2].size(); i++) {
        // Edge edge = graph[2].get(i);
        // System.out.println(edge.dest);
        // }

        // bfs(graph);
        // dfs(graph, 0, new boolean[V]);
        // System.out.print(hasPath(graph, 0, 4, new boolean[V]));
        prims(graph);

    }
}