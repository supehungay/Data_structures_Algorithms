package midterm.banacetree;

import java.util.Iterator;

public class BalanceTree<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key>{

    class Node {
        Key key;
        Node left, right;

        public Node(Key data) {
            key = data;
            left = right = null;
        }
    }

    private Node root;
    private int n;

    public BalanceTree() {
        root = null;
        n = 0;
    }

    public Node balance(Node node) {
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight - rightHeight > 1 && getHeight(node.left.left) > getHeight(node.left.right)) {
            node = rightRotate(node);
        } else if (leftHeight - rightHeight < 1 && getHeight(node.right.left) < getHeight(node.right.right)) {
            node = leftRotate(node);
        } else if (leftHeight - rightHeight > 1 && getHeight(node.left.left) < getHeight(node.left.right)) {
            node.left = leftRotate(node.left);
            node = rightRotate(node);
        } else if (leftHeight - rightHeight < 1 && getHeight(node.right.left) > getHeight(node.right.right)) {
            node.right = rightRotate(node.right);
            node = leftRotate(node);
        } 

        return node;
    }


    public Node rightRotate(Node node) {
        Node newNode = node.left;
        Node tempNode = newNode.right;

        newNode.right = node;
        node.left = tempNode;

        return newNode;
    }

    public Node leftRotate(Node node){
        Node newNode = node.right;
        Node tempNode = newNode.left;

        newNode.left = node;;
        node.right = tempNode;

        return newNode;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public void insert(Key k) {
        root = insert(root, k);
    }

    private Node insert(Node node, Key key) {
        if (node == null) {
            return new Node(key);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        return balance(node);
    }

    @Override
	public Key search(Key k) {
		Node currentNode = root;
		Node result = search(currentNode, k);
		if (result != null) {
			return result.key;
		}
		return null;
	}

	private Node search(Node node, Key k) {
		if (node == null || k.compareTo(node.key) == 0) {
			return node;
		} 

		if (k.compareTo(node.key) < 0) {
			return search(node.left, k);
		} else {
			return search(node.right, k);
		} 
	}

    @Override
    public Key delete(Key k) {
        root = delete(root, k);
        return root.key;
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left != null && node.right != null) {
                node.key = minValue(node.right);
                node.right = delete(node.right, node.key);
            } else {
                return (node.left == null) ? node.right : node.left;
            }
        }
        return balance(node);
    }

    private Key minValue(Node node) {
        Key minVal = node.key;
        while (node.left != null) {
            minVal = node.left.key;
            node = node.left;
        }
        return minVal;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
 
    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.key + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 
  

    public static void main(String[] args) { 
        BalanceTree<Integer> tree = new BalanceTree<>(); 
  
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25); 
  
        /* The constructed AVL Tree would be 
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
        */
        tree.delete(40);
        tree.delete(25);
        tree.delete(40);
        System.out.println("Preorder traversal" + 
                        " of constructed tree is : "); 
        tree.preOrder(tree.root); 
    } 
}
