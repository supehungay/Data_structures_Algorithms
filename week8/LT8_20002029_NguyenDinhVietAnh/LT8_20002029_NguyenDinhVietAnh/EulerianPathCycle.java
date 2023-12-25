package LT8_20002029_NguyenDinhVietAnh;

import java.util.LinkedList;

public class EulerianPathCycle {

	private int V;
	private LinkedList<Integer>[] adj;

	public EulerianPathCycle(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	private int isEulerian() {
		int odd = 0;
		for (int i = 0; i < V; ++i) {
			if (adj[i].size() % 2 != 0) {
				odd++;
			}
		}
		if (odd == 0) {
			return 2; // Eulerian Cycle
		} else if (odd == 2) {
			return 1; // Eulerian Path
		} else {
			return 0; // Not Eulerian
		}
	}

	private void DFS(int v) {
		System.out.print(v + " ");
		for (int neighbor : adj[v]) {
			if (neighbor != -1 && isValidNextEdge(v, neighbor)) {
				removeEdge(v, neighbor);
				DFS(neighbor);
			}
		}
	}

	private boolean isValidNextEdge(int u, int v) {
		int count = 0;
		for (int neighbor : adj[u]) {
			if (neighbor != -1) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		}

		boolean[] visited = new boolean[V];
		int count1 = DFSCount(u, visited);

		removeEdge(u, v);
		visited = new boolean[V];
		int count2 = DFSCount(u, visited);

		addEdge(u, v);

		return (count1 > count2) ? false : true;
	}

	private int DFSCount(int v, boolean[] visited) {
		visited[v] = true;
		int count = 1;
		for (int neighbor : adj[v]) {
			if (neighbor != -1 && !visited[neighbor]) {
				count += DFSCount(neighbor, visited);
			}
		}
		return count;
	}

	private void removeEdge(int u, int v) {
		adj[u].remove((Integer) v);
		adj[v].remove((Integer) u);
	}

	public void printEulerianPathCycle() {
		int result = isEulerian();
		if (result == 0) {
			System.out.println("The graph is not Eulerian.");
		} else {
			int startVertex = 0;
			for (int i = 0; i < V; i++) {
				if (adj[i].size() % 2 != 0) {
					startVertex = i;
					break;
				}
			}
			System.out.print("Eulerian Path/Cycle starting from vertex " + startVertex + ": ");
			DFS(startVertex);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		EulerianPathCycle eulerianPathCycle = new EulerianPathCycle(10);
	
		eulerianPathCycle.addEdge(0, 1);
		eulerianPathCycle.addEdge(1, 2);
		eulerianPathCycle.addEdge(2, 3);
		eulerianPathCycle.addEdge(3, 4);
		eulerianPathCycle.addEdge(4, 5);
		eulerianPathCycle.addEdge(5, 6);
		eulerianPathCycle.addEdge(6, 7);
		eulerianPathCycle.addEdge(7, 8);
		eulerianPathCycle.addEdge(8, 9);
		eulerianPathCycle.addEdge(9, 0);
	
		eulerianPathCycle.printEulerianPathCycle();
	}
	
}
