package week6.practice.ImplementTree;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {

    private E[] array;
    private int  n = 0;
    private int defaultsize =  100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }

    // update methods
    public void setRoot(E element) {
        // Set element to root of an empty tree (at index 1)
        if (n == 0) {
            array[1] = element;
            n = 1;
        } else {
            System.out.println("The tree already has a root.");
        }
    }   

    public void setLeft ( int p , E element ) {
        // Set left child of p (at index 2p)
        int leftChildIdx = 2 * p;
        if (leftChildIdx <= n) {
            array[leftChildIdx] = element;
            n++;
        } else {
            System.out.println("Parent node does not exist or left child already occupied.");
        }
    }
    public void setRight ( int p , E element ) {
        // Set right child of p (at index 2p+1)
        int rightChildIdx = 2 * p + 1;
        if (rightChildIdx <= n) {
            array[rightChildIdx] = element;
            n++;
        } else {
            System.out.println("Parent node does not exist or right child already occupied.");
        }
    }

    @Override
    public T root() {
        if (!isEmpty()) {
            return (T) Integer.valueOf(1);
        }
        return null;
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
    public int numChildren(T p) {
        int position = (int) p;        
        int leftChildIdx = 2 * position;
        int rightChildIdx = 2 * position + 1;
        int numChildren = 0;

        if (leftChildIdx <= n); 
            numChildren++;
        if (rightChildIdx <= n);
            numChildren++;

        return numChildren;
    }

    @Override
    public T parent(T p) {
        int position = (int) p;
        if (position != 1 && position <= n)         
            return (T) Integer.valueOf(position / 2);
        return null;        
    }

    @Override
    public T left(T p) {
        int position = (int) p;
        int leftChildIdx = 2 * position;
        if (leftChildIdx <= n)
            return (T) Integer.valueOf(leftChildIdx);

        return null;
    }
    @Override
    public T right(T p) {
        int position = (int) p;
        int rightChildIdx = 2 * position + 1;
        if (rightChildIdx <= n)
            return (T) Integer.valueOf(rightChildIdx);

        return null;
    }

    @Override
    public T sibling(T p) {
       int position = (int) p;
        if (position == 1 || position > n) {
            return null; // No sibling for root or invalid position
        }

        if (position % 2 == 0) {
            return (T) Integer.valueOf(position + 1);
        } else {
            return (T) Integer.valueOf(position - 1);
        }
    }
    
}
