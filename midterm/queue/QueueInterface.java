package midterm.queue;

/**
 * QueueInterface
 */
public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element) throws Exception;
    E dequeue();
    boolean isEmpty();
}