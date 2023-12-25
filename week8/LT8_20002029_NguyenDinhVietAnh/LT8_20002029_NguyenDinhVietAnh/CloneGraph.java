package LT8_20002029_NguyenDinhVietAnh;

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

		// Map để lưu trữ mối quan hệ giữa đỉnh cũ và đỉnh mới
		Map<Node, Node> visited = new HashMap<>();

		// Queue để thực hiện BFS
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		// Tạo đỉnh mới cho đỉnh gốc
		visited.put(node, new Node(node.val));

		// Bắt đầu BFS
		while (!queue.isEmpty()) {
			Node current = queue.poll();

			// Duyệt qua các đỉnh láng giềng
			for (Node neighbor : current.neighbors) {
				// Nếu đỉnh láng giềng chưa được thăm
				if (!visited.containsKey(neighbor)) {
					// Tạo đỉnh mới cho đỉnh láng giềng
					visited.put(neighbor, new Node(neighbor.val));
					// Thêm đỉnh láng giềng mới vào hàng đợi để duyệt tiếp
					queue.add(neighbor);
				}

				// Thêm đỉnh láng giềng mới vào đỉnh mới tương ứng
				visited.get(current).neighbors.add(visited.get(neighbor));
			}
		}

		// Trả về đỉnh mới của đồ thị đã clone
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
		// Example usage
		CloneGraph cloneGraph = new CloneGraph();

		// Create a sample graph
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

		// Clone the graph
		Node clonedGraph = cloneGraph.cloneGraph(node1);
		cloneGraph.dfsTraversal(node1);
	}
}
