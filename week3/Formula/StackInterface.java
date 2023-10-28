package week3.Formula;

/**
 * StackInterface
 */
public interface StackInterface<T> extends Iterable<T> {
    void push(T element);
    T pop();
    boolean isEmpty();
}