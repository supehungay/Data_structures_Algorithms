package week6.draft;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
	private E[] array;
	private int n = 0;
	private int defaultsize = 100;

	public ArrayBinaryTree() {
		this.array = (E[]) new Object[defaultsize];
	}

	public void setRoot(E element) {
		this.array[n++] = element;
	}

	public void setLeft(int p, E element) {
		int childLeft = 2 * p;
		if (array[p] == null) {
			System.out.printf("Can't set child at %d, no parent found \n", childLeft);
		} else {
			array[childLeft] = element;
			n += 1;
		}
	}

	public void setRight(int p, E element) {
		int t = 2 * p + 1;
		if (array[p] == null) {
			System.out.printf("Can't set child at %d, no parent found \n", t);
		} else {
			array[t] = element;
			n += 1;
		}
	}

	public void printTree() {
		for (int i = 0; i < this.defaultsize; i++) {
			if (array[i] != null) {
				System.out.print(array[i]);
			} else {
				System.out.print("-");
			}
		}
	}

	@Override
	public T root() {
		if (n > 0) {
			return (T) array[0];
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public int numChildren(T p) {
		// TODO Auto-generated method stub
		int t = 2 * (int) p;
		int counter = 0;
		if (this.array[t + 1] != null)
			counter += 1;
		if (this.array[t + 2] != null)
			counter += 1;
		return counter;
	}

	@Override
	public T parent(T p) {
		int t = (int) p / 2;
		return (T) this.array[t];
	}

	@Override
	public T left(T p) {
		// TODO Auto-generated method stub
		return (T) this.array[(int) p * 2 + 1];
	}

	@Override
	public T right(T p) {
		// TODO Auto-generated method stub
		return (T) this.array[(int) p * 2 + 2];
	}

	@Override
	public T sibling(T p) {
		int t = (int) p / 2;
		if ((int) p % 2 == 1) {
			return (T) this.array[t + 2];
		} else {
			return (T) this.array[t + 1];
		}
	}

}
