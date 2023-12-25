
package week8.practice.example4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import week8.practice.example4.Graph.WeightedEdge;

// import week8.practice.example4.Graph;

/**
 * GraphAlgorithms
 */
public class GraphAlgorithms {

    private Graph genGraph;
    public GraphAlgorithms(int vertices, int edges) {
        genGraph = Graph.generateRandomGraph(5, 5);
        Graph.printGraph(genGraph);
    }

    public void dfs(int startV) {
        System.out.println();
        System.out.println("dfs traversal:");

        boolean[] visited = new boolean[genGraph.getVertices()];
		Stack<Integer> stack = new Stack<>();
		stack.push(startV);

		while (!stack.isEmpty()) {
			startV = stack.pop();
			if (!visited[startV - 1]) {
				System.out.print(startV + " ");
				visited[startV - 1] = true;
			}
            List<WeightedEdge> neighbors = genGraph.getNeighbors(startV);
			for (WeightedEdge neighborEdge : neighbors) {
                int neighbor = neighborEdge.getDestination();
				if (!visited[neighbor - 1]) {
					stack.push(neighbor);
				}
			}
		}
        System.out.println();
    }

    public void bfs(int startV) {
        System.out.println();
        System.out.println("bfs traversal:");
		boolean[] visited = new boolean[genGraph.getVertices()];
		Queue<Integer> queue = new LinkedList<>();
		visited[startV - 1] = true;
		queue.add(startV);

		while (!queue.isEmpty()) {
			startV = queue.poll();
			System.out.print(startV + " ");

            List<WeightedEdge> neighbors = genGraph.getNeighbors(startV);
			for (WeightedEdge neighborEdge : neighbors) {
                int neighbor = neighborEdge.getDestination();
				if (!visited[neighbor - 1]) {
					visited[neighbor - 1] = true;
					queue.add(neighbor);
				}
			}
		}
        System.out.println();
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
        // Graph newGraph = Graph.generateRandomGraph(5, 5);
        // Graph.printGraph(newGraph);
        // Map<Integer, List<Integer>> a = newGraph.getAdjacencyList();
        // System.out.println(a.values());
        GraphAlgorithms gAlgorithms = new GraphAlgorithms(5, 5);
        gAlgorithms.dfs(1);
        gAlgorithms.bfs(1);
        gAlgorithms.dijkstra(1, 3);
    }
}