import java.util.*;

// Class representing a node in the game search problem
class Node {
    int x, y; // Coordinates of the node
    int cost; // Cost to reach this node from the start node
    int heuristic; // Heuristic value (estimated cost to reach the goal node)
    int totalCost; // Total cost = cost + heuristic

    // Constructor
    Node(int x, int y, int cost, int heuristic) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.heuristic = heuristic;
        this.totalCost = cost + heuristic;
    }
}

// Comparator for priority queue based on total cost
class NodeComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
        return n1.totalCost - n2.totalCost;
    }
}

// Class representing the A* algorithm
class AStar {
    final static int ROW = 5; // Number of rows in the grid
    final static int COL = 5; // Number of columns in the grid

    // Function to find the shortest path from the start cell to the destination cell using A* algorithm
    static void aStarSearch(int grid[][], int srcRow, int srcCol, int destRow, int destCol) {
        // If source or destination is blocked, return
        if (grid[srcRow][srcCol] == 0 || grid[destRow][destCol] == 0) {
            System.out.println("Source or destination is blocked.");
            return;
        }

        // If source and destination cells are the same
        if (srcRow == destRow && srcCol == destCol) {
            System.out.println("Source is the destination.");
            return;
        }

        // Create a priority queue for open nodes
        PriorityQueue<Node> open = new PriorityQueue<>(new NodeComparator());

        // Set of visited cells
        boolean[][] closed = new boolean[ROW][COL];

        // Initialize the starting node
        Node start = new Node(srcRow, srcCol, 0, Math.abs(srcRow - destRow) + Math.abs(srcCol - destCol));
        open.add(start);

        // Arrays to store the row and column coordinates of 4 neighbors
        int[] rowNum = {-1, 0, 0, 1};
        int[] colNum = {0, -1, 1, 0};

        // Loop until the open priority queue is empty
        while (!open.isEmpty()) {
            // Remove the node with the lowest total cost from the priority queue
            Node current = open.poll();

            // Mark the current cell as visited
            closed[current.x][current.y] = true;

            // Check if the destination node is reached
            if (current.x == destRow && current.y == destCol) {
                System.out.println("Path found. Total cost: " + current.totalCost);
                return;
            }

            // Explore the neighbors of the current node
            for (int i = 0; i < 4; i++) {
                int newRow = current.x + rowNum[i];
                int newCol = current.y + colNum[i];

                // Check if the neighbor is valid and unblocked
                if (newRow >= 0 && newRow < ROW && newCol >= 0 && newCol < COL &&
                        grid[newRow][newCol] == 1 && !closed[newRow][newCol]) {
                    int newCost = current.cost + 1; // Cost to move to the neighbor
                    int newHeuristic = Math.abs(newRow - destRow) + Math.abs(newCol - destCol); // Heuristic value
                    int newTotalCost = newCost + newHeuristic; // Total cost

                    // Create a new node for the neighbor
                    Node neighbor = new Node(newRow, newCol, newCost, newHeuristic);
                    neighbor.totalCost = newTotalCost;

                    // Add the neighbor to the open priority queue
                    open.add(neighbor);
                }
            }
        }

        // If the destination node is not reachable
        System.out.println("Destination not reachable.");
    }
}

// Main class
public class Main {
    public static void main(String args[]) {
        int grid[][] = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1}
        };
        int srcRow = 0, srcCol = 0;
        int destRow = 4, destCol = 4;

        AStar.aStarSearch(grid, srcRow, srcCol, destRow, destCol);
    }
}
