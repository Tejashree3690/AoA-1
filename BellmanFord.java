import java.util.*;
 class Edge {
     int src, dest, weight;
     Edge(int src, int dest, int weight) 
     {
         this.src = src;
         this.dest = dest;
         this.weight = weight;
     }
 }
 
 public class BellmanFord 
 {
     public static void bellmanFord(List<Edge> edges, int V, int E, int src) {
         int[] distance = new int[V];
         int[] predecessor = new int[V];
         Arrays.fill(distance, Integer.MAX_VALUE);
         Arrays.fill(predecessor, -1);
         distance[src] = 0;
 
         for (int i = 1; i < V; i++) {
             for (int j = 0; j < E; j++) {
                 int u = edges.get(j).src;
                 int v = edges.get(j).dest;
                 int weight = edges.get(j).weight;
                 if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                     distance[v] = distance[u] + weight;
                     predecessor[v] = u;
                 }
             }
         }
 
         for (int j = 0; j < E; j++) {
             int u = edges.get(j).src;
             int v = edges.get(j).dest;
             int weight = edges.get(j).weight;
             if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                 System.out.println("Graph contains a negative weight cycle");
                 return;
             }
         }
 
         System.out.println("Vertex distances from source:");
         for (int i = 0; i < V; i++) {
             System.out.println(i + " -> " + distance[i]);
         }
 
         System.out.println("\nShortest paths:");
         for (int i = 0; i < V; i++) {
             if (i != src) {
                 printPath(predecessor, i);
                 System.out.println(" -> " + i + " (Distance: " + distance[i] + ")");
             }
         }
     }
 
     private static void printPath(int[] predecessor, int vertex) {
         if (vertex == -1) {
             return;
         }
         printPath(predecessor, predecessor[vertex]);
         System.out.print(vertex + " ");
     }
 
     public static void main(String[] args) {
         int V = 5, E = 8;
         List<Edge> edges = Arrays.asList(
                 new Edge(0, 1, 1),
                 new Edge(0, 2, 4),
                 new Edge(1, 2, 3),
                 new Edge(1, 3, 2),
                 new Edge(1, 4, 2),
                 new Edge(3, 2, 5),
                 new Edge(3, 1, 1),
                 new Edge(4, 3, 3));
 
         bellmanFord(edges, V, E, 0);
     }
 }