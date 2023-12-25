package LT8_20002029_NguyenDinhVietAnh;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

	private int V;
	private LinkedList<Integer>[] adjacencyList;

	public GraphTraversal(int v) {
		V = v;
		adjacencyList = new LinkedList[V];
		for (int i = 0; i < V; ++i) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adjacencyList[v].add(w);
		adjacencyList[w].add(v);
	}

	public void DFS(int s) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		stack.push(s);

		while (!stack.isEmpty()) {
			s = stack.pop();
			if (!visited[s]) {
				System.out.print(s + " ");
				visited[s] = true;
			}

			for (int neighbor : adjacencyList[s]) {
				if (!visited[neighbor]) {
					stack.push(neighbor);
				}
			}
		}
	}

	public void BFS(int s) {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");

			for (int neighbor : adjacencyList[s]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		GraphTraversal graph = new GraphTraversal(10);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(5, 6);
		System.out.println("DFS starting from vertex 1:");
		graph.DFS(1);

		System.out.println("\nBFS starting from vertex 0:");
		graph.BFS(0);
	}
}
