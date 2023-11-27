
class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	Node covertMirror(Node node) {
        if (node == null) {
            return node;
        }
 
        Node left = covertMirror(node.left);
        Node right = covertMirror(node.right);
 
        node.left = right;
        node.right = left;
 
        return node;
	}

	int getWidthTree(Node node) {
		int maxWidth = 0;
		int width;
		int h = height(node);

		for (int i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}

    private int height(Node node) {
		if (node == null) {
			return -1;
        } else {
			int leftHeight = height(node.left);
			int rightHeight = height(node.right);

			return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
		}
	}

    private int getWidth(Node node, int level) {
		if (node == null) {
			return -1;
        }

		if (level == 1) {
			return 1;
        } else if (level > 1) {
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
        }
		return 0;
	}
}