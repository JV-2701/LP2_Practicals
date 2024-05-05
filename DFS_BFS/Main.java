import java.util.*;

// Class representing a graph
// Class representing a graph
class Graph {
    private int V; // Number of vertices
    private List<Integer> adj[]; // Adjacency list
//this is my code
    // Constructor
    Graph(int v) {
        V = v;
       
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Recursive function for Depth First Search traversal
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        for (Integer n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Depth First Search traversal
    void DFS(int v) {
        // Mark all the vertices as not visited(set as false by default in Java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // Breadth First Search traversal
    void BFS(int s) {
        // Mark all the vertices as not visited (set as false by default in Java)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent vertex has not been visited, then mark it
            // visited and enqueue it
            for (Integer n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}


// Main class
public class Main {
    public static void main(String args[]) {
        // Create a graph
        Graph g = new Graph(4);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Depth First Traversal:");
        g.DFS(0);
        System.out.println("\nBreadth First Traversal:");
        g.BFS(0);
    }
}
