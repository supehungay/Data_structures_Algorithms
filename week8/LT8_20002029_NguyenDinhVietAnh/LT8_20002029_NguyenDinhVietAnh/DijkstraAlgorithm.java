package LT8_20002029_NguyenDinhVietAnh;

import java.util.*;

public class DijkstraAlgorithm {

	private int V; // Số đỉnh trong đồ thị
	private List<List<Node>> adjacencyList;

	class Node {
		int vertex, weight;

		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	// Khởi tạo đồ thị với số đỉnh V
	public DijkstraAlgorithm(int v) {
		V = v;
		adjacencyList = new ArrayList<>(V);

		for (int i = 0; i < V; ++i) {
			adjacencyList.add(new ArrayList<>());
		}
	}

	// Thêm một cạnh vào đồ thị với trọng số
	public void addEdge(int source, int destination, int weight) {
		adjacencyList.get(source).add(new Node(destination, weight));
	}

	// Thuật toán Dijkstra
	public void dijkstra(int source) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		priorityQueue.add(new Node(source, 0));
		distance[source] = 0;

		while (!priorityQueue.isEmpty()) {
			int u = priorityQueue.poll().vertex;

			for (Node neighbor : adjacencyList.get(u)) {
				int v = neighbor.vertex;
				int weight = neighbor.weight;

				if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
					distance[v] = distance[u] + weight;
					priorityQueue.add(new Node(v, distance[v]));
				}
			}
		}
		printResult(distance, source);
	}

	private void printResult(int[] distance, int source) {
		System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
		for (int i = 0; i < V; ++i) {
			System.out.println("To vertex " + i + ": " + distance[i]);
		}
	}

	public static void main(String[] args) {
		DijkstraAlgorithm graph = new DijkstraAlgorithm(5);

		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 7);
		graph.addEdge(2, 4, 3);
		graph.addEdge(3, 4, 1);

		int sourceVertex = 0;
		graph.dijkstra(sourceVertex);
	}
}
