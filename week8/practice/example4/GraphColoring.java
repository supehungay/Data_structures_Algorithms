package week8.practice.example4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphColoring {

	private int V;
	private LinkedList<Integer>[] adjList;

	public GraphColoring(int v) {
		V = v;
		adjList = new LinkedList[V];
		for (int i = 0; i < V; ++i) {
			adjList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
	}

	public void greedyColoring() {
		int result[] = new int[V];
		Arrays.fill(result, -1);

		result[0] = 0;

		boolean available[] = new boolean[V];
		Arrays.fill(available, true);

		for (int u = 1; u < V; u++) {
			Iterator<Integer> iterator = adjList[u].iterator();
			while (iterator.hasNext()) {
				int v = iterator.next();
				if (result[v] != -1) {
					available[result[v]] = false;
				}
			}

			int cr;
			for (cr = 0; cr < V; cr++) {
				if (available[cr]) {
					break;
				}
			}

			result[u] = cr;

			Arrays.fill(available, true);
		}

		System.out.println("Vertex \tColor");
		for (int u = 0; u < V; u++) {
			System.out.println(u + " \t" + result[u]);
		}

		int chromaticNumber = Arrays.stream(result).max().getAsInt() + 1;
		System.out.println("\nChromatic Number: " + chromaticNumber);
	}

	public static void main(String[] args) {
		GraphColoring graph = new GraphColoring(10);
	
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 9);
		graph.addEdge(9, 0);
	
		System.out.println("Graph Coloring using Greedy Algorithm:");
		graph.greedyColoring();
	}
	
}
