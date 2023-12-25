package week8.practice.example4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import week8.practice.example4.Graph.WeightedEdge;

public class Traversal {
    private Graph genGraph;
    public Traversal(int vertices, int edges) {
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

    public static void main(String[] args) {
        GraphAlgorithms gAlgorithms = new GraphAlgorithms(5, 5);
        gAlgorithms.dfs(1);
        gAlgorithms.bfs(1);
    }
}
