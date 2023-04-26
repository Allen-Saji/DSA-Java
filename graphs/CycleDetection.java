package graphs;

import java.util.*;

public class CycleDetection {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }

            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
        }
        return false;
    }

    // if graph doesn't have any cycle, it will always be bipartite
    // even nodes cycle -> bipartite
    // odd nodes cycle -> non-bipartite
    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // no color
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0; // 0 -> red || 1 -> green
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false; // not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    // for directed graph
    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean[] vis, boolean[] stack) {
        stack[curr] = true;
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true; // cycle exist
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src == dest){
            System.out.println(path+src);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e  = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void calcIndegree(ArrayList<Edge> graph[], int indegree[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }

    // using bfs (kahn's method)
    public static void topSort(ArrayList<Edge> graph[]) {
        int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calcIndegree(graph, indegree);

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr + " "); // topological sort print

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;

                if (indegree[e.dest] == 0) {
                    q.add(indegree[e.dest]);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 4; // no. of vertices of graph
        ArrayList<Edge>[] graph = new ArrayList[V]; // array of arraylist
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // // 0th vertex
        // graph[0].add(new Edge(0, 1));

        // // 1st vertex
        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));
        // graph[1].add(new Edge(1, 3));

        // // 2nd vertex
        // graph[2].add(new Edge(2, 1));
        // graph[2].add(new Edge(2, 4));
        // graph[2].add(new Edge(2, 3));

        // // 3rd vertex
        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 2));

        // // 4th vertex
        // graph[4].add(new Edge(4, 2));

        // directed graph
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));

        // System.out.println(detectCycle(graph));
        // System.out.println(isBipartite(graph));
        // System.out.println(isCycle(graph));
        topologicalSort(graph);
    }
}
