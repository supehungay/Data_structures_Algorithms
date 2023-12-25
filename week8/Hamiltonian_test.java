// package week8;
// import week8.practice.example4.Graph;
// // import week8.practice.example4.Graph.WeightedEdge;

// import java.util.ArrayList;
// import java.util.List;

// public class Hamiltonian_test {

//     private Graph genGraph;

//     public Hamiltonian_test(int vertices, int edges) {
//         genGraph = Graph.generateRandomGraph(vertices, edges);
//         Graph.printGraph(genGraph);
//     }

//     public void hamiltonianPath() {
//         System.out.println();
//         System.out.println("Hamiltonian Path:");

//         List<Integer> path = new ArrayList<>();
//         boolean[] visited = new boolean[genGraph.getVertices()];

//         // Bắt đầu từ đỉnh 1
//         path.add(1);
//         visited[0] = true;

//         if (hamiltonianPathUtil(1, path, visited)) {
//             System.out.println("Hamiltonian path exists: " + path);
//         } else {
//             System.out.println("No Hamiltonian path exists");
//         }
//     }

// private boolean hamiltonianPathUtil(int currentVertex, List<Integer> path, boolean[] visited) {
//     if (path.size() == genGraph.getVertices()) {
//         // Đã thăm tất cả các đỉnh
//         return true;
//     }

//     List<WeightedEdge> neighbors = genGraph.getNeighbors(currentVertex);

//     for (WeightedEdge neighborEdge : neighbors) {
//         int neighbor = neighborEdge.getDestination();

//         if (!visited[neighbor - 1]) {
//             path.add(neighbor);
//             visited[neighbor - 1] = true;

//             if (hamiltonianPathUtil(neighbor, path, visited)) {
//                 return true;
//             }

//             // Backtrack nếu không tìm được đường đi
//             path.remove(path.size() - 1);
//             visited[neighbor - 1] = false;
//         }
//     }

//     return false;
// }

//     public static void main(String[] args) {
//         Hamiltonian_test gAlgorithms = new Hamiltonian_test(5, 5);
//         gAlgorithms.hamiltonianPath();
//     }
// }
