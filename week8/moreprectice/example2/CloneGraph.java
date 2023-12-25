package week8.moreprectice.example2;

import java.util.*;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<>();
	}

	public Node(int val) {
		this.val = val;
		neighbors = new ArrayList<>();
	}

	public Node(int val, ArrayList<Node> neighbors) {
		this.val = val;
		this.neighbors = neighbors;
	}
}

public class CloneGraph {

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		Map<Node, Node> visited = new HashMap<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		visited.put(node, new Node(node.val));

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			for (Node neighbor : current.neighbors) {
				if (!visited.containsKey(neighbor)) {
					visited.put(neighbor, new Node(neighbor.val));
					queue.add(neighbor);
				}

				visited.get(current).neighbors.add(visited.get(neighbor));
			}
		}

		return visited.get(node);
	}

	public void dfsTraversal(Node node) {
		Set<Node> visited = new HashSet<>();
		dfs(node, visited);
	}

	private void dfs(Node node, Set<Node> visited) {
		if (node == null || visited.contains(node)) {
			return;
		}

		System.out.print(node.val + " ");
		visited.add(node);

		for (Node neighbor : node.neighbors) {
			dfs(neighbor, visited);
		}
	}

	public static void main(String[] args) {
		CloneGraph cloneGraph = new CloneGraph();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.neighbors.add(node2);
		node1.neighbors.add(node4);

		node2.neighbors.add(node1);
		node2.neighbors.add(node3);

		node3.neighbors.add(node2);
		node3.neighbors.add(node4);

		node4.neighbors.add(node1);
		node4.neighbors.add(node3);

		Node clonedGraph = cloneGraph.cloneGraph(node1);
		cloneGraph.dfsTraversal(node1);
	}
}
