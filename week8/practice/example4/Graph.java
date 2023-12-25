package week8.practice.example4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Graph {

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

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();

        for (int i = 1; i <= vertices; i++) {
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

    public static Graph generateRandomGraph(int vertices, int edges) {
        Graph graph = new Graph(vertices);
        Random random = new Random();

        for (int i = 0; i < edges; i++) {
            int v1 = random.nextInt(vertices) + 1;
            int v2 = random.nextInt(vertices) + 1;
            int weight = random.nextInt(10) + 1;
            if (v1 == v2 || graph.adjacencyList.get(v1).contains(v2)) {
                i--;
                continue;
            } 
            graph.addEdge(v1, v2, weight);
        }
        return graph;
    }

    public static void printGraph(Graph graph) {
        System.out.println("Graph:");

        for (int vertex = 1; vertex <= graph.getVertices(); vertex++) {
            System.out.print(vertex + " -> ");
            List<WeightedEdge> neighbors = graph.getNeighbors(vertex);
            for (WeightedEdge edge : neighbors) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}
