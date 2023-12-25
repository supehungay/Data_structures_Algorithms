package week8.practice.example4;

import java.util.Arrays;

public class PrimMST {

	private static final int V = 5;

	// Tìm đỉnh có khoảng cách nhỏ nhất từ tập đỉnh chưa xét đến tập đỉnh đã xét
	private int minKey(int key[], boolean mstSet[]) {
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int v = 0; v < V; v++) {
			if (!mstSet[v] && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

	private void printMST(int parent[], int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++) {
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
		}
	}

	private void primMST(int graph[][]) {
		int parent[] = new int[V]; // Lưu trữ cây bao trùm tối thiểu
		int key[] = new int[V]; // Lưu trữ trọng số tối thiểu của mỗi đỉnh
		boolean mstSet[] = new boolean[V]; // Đánh dấu các đỉnh đã được thêm vào cây bao trùm

		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(mstSet, false);

		key[0] = 0; // Chọn đỉnh đầu tiên làm đỉnh xuất phát

		for (int count = 0; count < V - 1; count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		printMST(parent, graph);
	}

	public static void main(String[] args) {
		PrimMST primMST = new PrimMST();
	
		int graph[][] = new int[][] {
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 0, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 2, 0, 3, 0, 0, 0, 0, 0, 0},
			{0, 0, 3, 0, 4, 0, 0, 0, 0, 0},
			{0, 0, 0, 4, 0, 5, 0, 0, 0, 0},
			{0, 0, 0, 0, 5, 0, 6, 0, 0, 0},
			{0, 0, 0, 0, 0, 6, 0, 7, 0, 0},
			{0, 0, 0, 0, 0, 0, 7, 0, 8, 0},
			{0, 0, 0, 0, 0, 0, 0, 8, 0, 9},
			{0, 0, 0, 0, 0, 0, 0, 0, 9, 0}
		};
	
		primMST.primMST(graph);
	}
	
}
