package week4.assigment.extraExercise.Ex3;

/**
 * QueueInterface
 */
public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element) throws Exception;
    E dequeue();
    boolean isEmpty();
}