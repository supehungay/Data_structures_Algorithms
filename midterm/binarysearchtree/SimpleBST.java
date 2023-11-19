package midterm.binarysearchtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {
	
	class Node{
		Key data;
		Node left, right;
		public Node(Key key)
		{
			this.data =  key;
		}
	}
	
	private Node root = null;
	int n = 0;

	@Override
	public void insert(Key k) {
		// if (root == null) {
		// 	root = new Node(k);
		// 	n++;
		// 	return;
		// }
		// Node parent = null;
		// Node current = root;
		// while (current != null) {
		// 	if (k.compareTo(current.data) < 0) {
		// 		parent = current;
		// 		current = current.left;
		// 	} else if (k.compareTo(current.data) >= 0) {
		// 		parent = current;
		// 		current = current.right;
		// 	}
		// 	//  else {
		// 	// 	// System.out.println(k + " Đã tồn tại trong cây nhị phân");
		// 	// 	return;
		// 	// }
		// }
		// if (k.compareTo(parent.data) < 0) {
		// 	parent.left = new Node(k);
		// } else {
		// 	parent.right = new Node(k);
		// }
		// n++;
		root = insert(root, k);
	}

	private Node insert(Node node, Key k) {
		if (node == null) {
			return new Node(k);
		} 

		if (k.compareTo(node.data) < 0) {
			node.left = insert(node.left, k);
		} else {
			node.right = insert(node.right, k);
		}
		return node;
	}
	
	@Override
	public Key search(Key k) {
		// Node currNode = root;
		// while (currNode != null) {
		// 	if (k.compareTo(currNode.data) < 0)
		// 		currNode = currNode.left;
		// 	else if (k.compareTo(currNode.data) > 0)
		// 		currNode = currNode.right;
		// 	else 
		// 		return currNode.data;
		// }	
		// // System.out.println(k + " Không tồn tại trong cây nhị phân");
		// return null;
		Node currentNode = root;
		Node result = search(currentNode, k);
		if (result != null) {
			return result.data;
		}
		return null;

	}

	private Node search(Node node, Key k) {
		if (node == null || k.compareTo(node.data) == 0) {
			return node;
		} 

		if (k.compareTo(node.data) < 0) {
			return search(node.left, k);
		} else {
			return search(node.right, k);
		} 
	}

	@Override
	public int size() {
		
		return n;
	}

	@Override
	public boolean isEmpty() {
		
		return n == 0;
	}
	
	@Override
	public Iterator<Key> iterator() {
		List<Key> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys.iterator();
	}

	private void inOrderTraversal(Node node, List<Key> keys) {
        if (node != null) {
            inOrderTraversal(node.left, keys);
            keys.add(node.data);
            inOrderTraversal(node.right, keys);
        }
    }
	
	//duyệt cây theo thứ tự trước (tiền thứ tự)
	public void preTraverse()
	{
		// if (root == null)
		// 	return;

		// Stack<Node> stack = new Stack<>();
		// Node currNode = root;

		// while (currNode != null || !stack.isEmpty()) {
		// 	while (currNode != null) {
		// 		System.out.println(currNode.data + " ");

		// 		if (currNode.right != null)
		// 			stack.push(currNode.right);
	
		// 		currNode = currNode.left;
		// 	}

		// 	if (!stack.isEmpty())
		// 		currNode = stack.pop();
		// 	currNode = currNode.right;
		// }

		if (root == null) 
			return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
	}
	
    // duyệt cây theo thứ tự sau (hậu thứ tự)
	public void postTraverse() {
		if (root == null) 
			return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().data + " ");
        }
	}
	

    // duyệt cây theo thứ tự giữa (trung thứ tự)
	public void inTraverse() {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<>();
		Node currNode = root;

		while (currNode != null || !stack.isEmpty()) {
			while (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}

			currNode = stack.pop();
			System.out.println(currNode.data + " ");
			currNode = currNode.right;
		}

	}
	
	
	

	public static void main(String[] args) {
		SimpleBST<Integer> bst =  new SimpleBST<>();
		
		int[] data = {5,6,7,1,2,3,8,6,9,0};
		for(int i = 0 ; i < data.length ; i++)
			bst.insert(data[i]);
		
		// System.out.println("All element in tree:");
		System.out.println("All element in tree:");
		int[] t = new int[data.length];
		int id = 0;
		for(int d:bst)
		{
			t[id] = d;
			id++;
		}
		
		Arrays.sort(t);
		for(int d:t)
		{
			System.out.print(d+" ");
		}
		
		System.out.println("");
		System.out.println("Size of tree = "+bst.size());
		
		System.out.println("Search key = 4> "+ bst.search(4));
		System.out.println("Search key = 6> "+bst.search(6));
		
		System.out.println("Pre-order tree traversal");
		bst.preTraverse();
		System.out.println("Post-order tree traversal");
		bst.postTraverse();
		System.out.println("In-order tree traversal");
		bst.inTraverse();
		
	}
	
	
	
}