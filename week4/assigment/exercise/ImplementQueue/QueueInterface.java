package week4.assigment.exercise.ImplementQueue;

/**
 * QueueInterface
 */
public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element) throws Exception;
    E dequeue();
    boolean isEmpty();
}