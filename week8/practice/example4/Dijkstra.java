package week8.practice.example4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import week8.practice.example4.Graph.WeightedEdge;

public class Dijkstra {

    private Graph genGraph;
    public Dijkstra(int vertices, int edges) {
        genGraph = Graph.generateRandomGraph(5, 5);
        Graph.printGraph(genGraph);
    }

    public void dijkstra(int source, int target) {
        System.out.println();
        System.out.println("Shortest Path (Dijkstra):");

        int[] distance = new int[genGraph.getVertices()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source - 1] = 0;

        boolean[] visited = new boolean[genGraph.getVertices()];
        PriorityQueue<VertexDistancePair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        minHeap.offer(new VertexDistancePair(source, 0));

        while (!minHeap.isEmpty()) {
            VertexDistancePair current = minHeap.poll();
            int currentVertex = current.vertex;

            if (visited[currentVertex - 1]) {
                continue;
            }

            visited[currentVertex - 1] = true;

            // Lấy danh sách các cạnh kề với currentVertex (có trọng số)
            List<WeightedEdge> neighbors = genGraph.getNeighbors(currentVertex);

            for (WeightedEdge neighborEdge : neighbors) {
                int neighbor = neighborEdge.getDestination();
                int newDistance = distance[currentVertex - 1] + neighborEdge.getWeight();

                if (newDistance < distance[neighbor - 1]) {
                    distance[neighbor - 1] = newDistance;
                    minHeap.offer(new VertexDistancePair(neighbor, newDistance));
                }
            }
        }

        printShortestPath(source, target, distance);
    }

    private void printShortestPath(int source, int target, int[] distance) {
        if (distance[target - 1] == Integer.MAX_VALUE) {
            System.out.println("No path from " + source + " to " + target);
            return;
        }

        List<Integer> path = new ArrayList<>();
        int current = target;

        while (current != source) {
            path.add(current);
            int minNeighbor = findMinNeighbor(current, distance);
            current = minNeighbor;
        }

        path.add(source);
        Collections.reverse(path);

        System.out.println("Shortest Path from " + source + " to " + target + ": " + path);
    }

    private int findMinNeighbor(int vertex, int[] distance) {
        List<WeightedEdge> neighbors = genGraph.getNeighbors(vertex);
        int minNeighbor = -1;
        int minDistance = Integer.MAX_VALUE;

        for (WeightedEdge neighborEdge : neighbors) {
            int neighbor = neighborEdge.getDestination();
            if (distance[neighbor - 1] < minDistance) {
                minDistance = distance[neighbor - 1];
                minNeighbor = neighbor;
            }
        }

        return minNeighbor;
    }

    private static class VertexDistancePair {
        int vertex;
        int distance;

        VertexDistancePair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        GraphAlgorithms gAlgorithms = new GraphAlgorithms(5, 5);
        gAlgorithms.dijkstra(1, 3);

    }
}
