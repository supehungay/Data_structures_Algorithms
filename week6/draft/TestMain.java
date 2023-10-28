package week6.draft;

public class TestMain {

	public static void main(String[] args) {
		testArratBinaryTree();

	}

	public static void testArratBinaryTree() {
		ArrayBinaryTree<String, Integer> tree = new ArrayBinaryTree<>();
	    tree.setRoot("A");
	    tree.setLeft(0, "B");
	    tree.setRight(0, "C");
	    tree.setLeft(1, "D");
	    tree.setRight(1, "E");
	    tree.setLeft(2, "F");
	    tree.setRight(2, "G");
	    tree.setLeft(3, "H");
	    tree.setRight(3, "I");
	    tree.setLeft(4, "J");
	    tree.setRight(4, "K");
	    tree.setLeft(5, "L");
	    tree.setRight(5, "M");
	    tree.setLeft(6, "N");
	    tree.setRight(6, "O");
	    tree.setRight(10, "haha");
	    tree.printTree();
	    
	    System.out.println("Size of tree is: " + tree.size());
	    System.out.println("Left node of 4: " + tree.left(4));
	}

}
