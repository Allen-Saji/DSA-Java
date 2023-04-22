package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public static void main(String[] args) {
        int V = 5; // no. of vertices of graph
        ArrayList<Edge>[] graph = new ArrayList[V]; // array of arraylist
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1st vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2nd vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 4));
        graph[2].add(new Edge(2, 3, 1));

        // 3rd vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4th vertex
        graph[4].add(new Edge(4, 2, 4));

        // 2's neighbours
        // for (int i = 0; i < graph[2].size(); i++) {
        // Edge edge = graph[2].get(i);
        // System.out.println(edge.dest);
        // }

        // bfs(graph);
        // dfs(graph, 0, new boolean[V]);
        System.out.print(hasPath(graph, 0, 4, new boolean[V]));

    }
}