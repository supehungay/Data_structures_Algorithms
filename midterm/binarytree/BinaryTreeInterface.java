package midterm.binarytree;

public interface BinaryTreeInterface<T> {
    T root();
    int size();
    boolean isEmpty();
    int numChildren(T p);

    T parent(T p); // return parent of p
    T left(T p); // return left child of p
    T right(T p); // return right child of p
    T sibling(T p); // return sibling of p
}
