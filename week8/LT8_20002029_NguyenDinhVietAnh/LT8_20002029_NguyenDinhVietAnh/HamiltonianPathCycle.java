package LT8_20002029_NguyenDinhVietAnh;

import java.util.Arrays;

public class HamiltonianPathCycle {

	private int V;
	private int[] path;

	public HamiltonianPathCycle(int v) {
		V = v;
		path = new int[V];
		Arrays.fill(path, -1);
	}

	public boolean isHamiltonianPath(int graph[][]) {
		path[0] = 0;
		if (!hamiltonianPathUtil(graph, path, 1)) {
			System.out.println("No Hamiltonian Path exists");
			return false;
		}
		printHamiltonianPath(path);
		return true;
	}

	private boolean hamiltonianPathUtil(int graph[][], int path[], int pos) {
		if (pos == V) {
			return true;
		}

		for (int v = 1; v < V; v++) {
			if (isSafe(v, graph, path, pos)) {
				path[pos] = v;
				if (hamiltonianPathUtil(graph, path, pos + 1)) {
					return true;
				}
				path[pos] = -1;
			}
		}
		return false;
	}

	private boolean isSafe(int v, int graph[][], int path[], int pos) {
		if (graph[path[pos - 1]][v] == 0) {
			return false;
		}

		for (int i = 0; i < pos; i++) {
			if (path[i] == v) {
				return false;
			}
		}

		return true;
	}

	private void printHamiltonianPath(int path[]) {
		System.out.println("Hamiltonian Path:");
		for (int i = 0; i < V; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println(path[0]);
	}

	public static void main(String args[]) {
		int graph[][] = { { 0, 1, 1, 1, 0 }, { 1, 0, 1, 0, 1 }, { 1, 1, 0, 1, 1 }, { 1, 0, 1, 0, 0 },
				{ 0, 1, 1, 0, 0 } };

		HamiltonianPathCycle hamiltonianPathCycle = new HamiltonianPathCycle(graph.length);
		hamiltonianPathCycle.isHamiltonianPath(graph);
	}
}
