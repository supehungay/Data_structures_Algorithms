package week8.moreprectice.example1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AdjacencyList {

    class WeightedEdge {
        private int destination;
        private int weight;
    
        public WeightedEdge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }
    }

    private int vertices;
    private Map<Integer, List<WeightedEdge>> adjacencyList;

    public AdjacencyList(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());                
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        adjacencyList.get(v1).add(new WeightedEdge(v2, weight));
        adjacencyList.get(v2).add(new WeightedEdge(v1, weight));
    }

    public List<WeightedEdge> getNeighbors(int v) {
        return adjacencyList.get(v);
    }

    public int getVertices() {
        return vertices;
    }

    public Map<Integer, List<WeightedEdge>> getAdjacencyList() {
        return adjacencyList;
    }

    public static AdjacencyList generateRandomAdjacencyList(int vertices, int edges) {
        AdjacencyList graph = new AdjacencyList(vertices);
        Random random = new Random();

        for (int i = 0; i < edges; i++) {
            int v1 = random.nextInt(vertices);
            int v2 = random.nextInt(vertices);
            int weight = random.nextInt(10) + 1;
            if (v1 == v2 || graph.adjacencyList.get(v1).contains(v2)) {
                i--;
                continue;
            } 
            graph.addEdge(v1, v2, weight);
        }
        return graph;
    }

    public static void printAdjacencyList(AdjacencyList graph) {
        System.out.println("Graph:");

        for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
            System.out.print("Vertex " + vertex + " is connected to: ");
            List<WeightedEdge> neighbors = graph.getNeighbors(vertex);
            for (WeightedEdge edge : neighbors) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        int edges = 8;

        AdjacencyList graph = AdjacencyList.generateRandomAdjacencyList(vertices, edges);

        // In đồ thị
        AdjacencyList.printAdjacencyList(graph);

    }
}
