package week6.draft;

public interface BinaryTreeInterface<T> {
	T root();
	int size();
	boolean isEmpty();
	int numChildren(T p);

	T parent(T p);
	T left(T p);
	T right(T p);
	T sibling(T p);
}
